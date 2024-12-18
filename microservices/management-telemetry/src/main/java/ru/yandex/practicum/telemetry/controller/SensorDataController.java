package ru.yandex.practicum.telemetry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SensorDataController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendSensorData(@RequestBody SensorData sensorData) {
        try {
            // Логгирование отправки
            logger.info("Отправка данных в топик: {}", sensorData);
            String str =  toString(sensorData);
            kafkaTemplate.send("sensor_data", sensorData.getTransactionId().toString(), str);
            return ResponseEntity.ok("Сообщение успешно отправлено");
        } catch (Exception e) {
            logger.error("Ошибка при отправке сообщения", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при отправке сообщения");
        }
    }

    private  String toString(SensorData sensorData) throws JsonProcessingException {

            // Создаем ObjectMapper для преобразования в строку JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Преобразуем объект в строку JSON
            String jsonString = objectMapper.writeValueAsString(sensorData);

            // Выводим результат
            return jsonString;

    }
}
