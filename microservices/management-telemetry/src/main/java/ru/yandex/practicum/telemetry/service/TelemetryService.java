package ru.yandex.practicum.telemetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.telemetry.dto.Telemetry;
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
        return telemetryRepository.findByDeviceIdAndData_Key(deviceId, "temperature");
    }

    public Telemetry createTelemetry(UUID deviceId, Map<String, Object> data) {
        Telemetry telemetry = new Telemetry();
        telemetry.setDeviceId(deviceId);
        telemetry.setTimestamp(LocalDateTime.now());
        telemetry.setData(data);
        return telemetryRepository.save(telemetry);
    }
}