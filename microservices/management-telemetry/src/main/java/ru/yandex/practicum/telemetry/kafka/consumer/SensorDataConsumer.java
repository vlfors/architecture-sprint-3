package ru.yandex.practicum.telemetry.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.telemetry.dto.SensorData;
import ru.yandex.practicum.telemetry.model.Telemetry;
import ru.yandex.practicum.telemetry.repository.TelemetryRepository;

import java.util.UUID;

@Service
public class SensorDataConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SensorDataConsumer.class);

    @Autowired
    TelemetryRepository telemetryRepository;

    @KafkaListener(topics = "sensor_data", groupId = "telemetry-group")
    public void receiveSensorData(String jsonString) throws JsonProcessingException {
        SensorData data = getSensorDataFromString(jsonString);

        logger.info("Получены данные от устройства {}: Температура - {}, Влажность - {}, Время - {}, transactionId - {}",

                data.getDeviceId(),
                data.getTemperature(),
                data.getHumidity(),
                data.getTimestamp(),
                data.getTransactionId());
        Telemetry telemetryTemperature = new Telemetry();
        telemetryTemperature.setId(UUID.randomUUID());
        telemetryTemperature.setTransactionId(data.getTransactionId());
        telemetryTemperature.setTimestamp(data.getTimestamp());
        telemetryTemperature.setMetricType("temperature");
        telemetryTemperature.setValue(data.getTemperature());
        telemetryRepository.save(telemetryTemperature);

        Telemetry humidityTemperature = new Telemetry();
        humidityTemperature.setId(UUID.randomUUID());
        humidityTemperature.setTransactionId(data.getTransactionId());
        humidityTemperature.setTimestamp(data.getTimestamp());
        humidityTemperature.setMetricType("humidity");
        humidityTemperature.setValue(data.getHumidity());
        telemetryRepository.save(humidityTemperature);



    }

    protected  static SensorData getSensorDataFromString(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());


        // Преобразуем строку JSON в объект SensorData
        SensorData data = objectMapper.readValue(jsonString, SensorData.class);
        return data;
    }
}