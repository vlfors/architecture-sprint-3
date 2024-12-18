package ru.yandex.practicum.telemetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.telemetry.dto.TelemetryDto;
import ru.yandex.practicum.telemetry.model.Telemetry;
import ru.yandex.practicum.telemetry.repository.TelemetryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TelemetryService {

    @Autowired
    private TelemetryRepository telemetryRepository;

    public List<Telemetry> getTelemetryData(UUID deviceId) {
        return telemetryRepository.findByDeviceId(deviceId);
    }

    public List<Telemetry> getTemperatureTelemetry(UUID deviceId) {
        return telemetryRepository.findByDeviceIdAndMetricType(deviceId, "temperature");
    }

    public Telemetry createTelemetry(UUID deviceId, TelemetryDto telemetry) {


        Map<String, Object> data = telemetry.getData();
        String metricType = (String) data.get("metricType");
        Double value = (data.get("value") instanceof Number) ? ((Number) data.get("value")).doubleValue() : null;


        if (metricType == null || value == null) {
            throw new IllegalArgumentException("Invalid data: metricType and value must be provided.");
        }


        Telemetry telemetryCreate = new Telemetry();
        telemetry.setTransactionId(telemetry.getTransactionId());
        telemetryCreate.setId(UUID.randomUUID()); // Генерируем уникальный идентификатор
        telemetryCreate.setDeviceId(deviceId); // Устанавливаем ID устройства
        telemetryCreate.setTimestamp(LocalDateTime.now()); // Устанавливаем временную метку
        telemetryCreate.setMetricType(metricType); // Устанавливаем тип метрики
        telemetryCreate.setValue(value); // Устанавливаем значение метрики


        return telemetryRepository.save(telemetryCreate);
    }
}