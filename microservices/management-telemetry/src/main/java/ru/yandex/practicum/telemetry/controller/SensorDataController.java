package ru.yandex.practicum.telemetry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.telemetry.dto.SensorData;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {

    private static final Logger logger = LoggerFactory.getLogger(SensorDataController.class);

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    @Autowired
    public SensorDataController(KafkaTemplate<String, SensorData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendSensorData(@RequestBody SensorData sensorData) {
        try {
            // Логгирование отправки
            logger.info("Отправка данных в топик: {}", sensorData);
            kafkaTemplate.send("sensor_data", sensorData.getTransactionId().toString(), sensorData);
            return ResponseEntity.ok("Сообщение успешно отправлено");
        } catch (Exception e) {
            logger.error("Ошибка при отправке сообщения", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при отправке сообщения");
        }
    }
}
