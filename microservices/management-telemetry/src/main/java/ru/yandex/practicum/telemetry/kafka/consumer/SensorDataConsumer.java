package ru.yandex.practicum.telemetry.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.telemetry.dto.SensorData;

@Service
public class SensorDataConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SensorDataConsumer.class);

    @KafkaListener(topics = "sensor_data", groupId = "telemetry-group")
    public void receiveSensorData(SensorData data) {
        logger.info("Получены данные от устройства {}: Температура - {}, Влажность - {}, Время - {}",
                data.getDeviceId(), data.getTemperature(), data.getHumidity(), data.getTimestamp());
    }
}