package ru.yandex.practicum.device.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.device.dto.DeviceStatus;

@Service
public class DeviceStatusPublisher {

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public DeviceStatusPublisher(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendDeviceStatus(DeviceStatus status) {
        try {
            String message = objectMapper.writeValueAsString(status);
            kafkaTemplate.send("device_statuses", message);
            System.out.printf("Sent status for device %d: %s%n", status.getDeviceId(), status.getStatus());
        } catch (JsonProcessingException e) {
            System.err.println("Error serializing DeviceStatus: " + e.getMessage());
        }
    }
}