package ru.yandex.practicum.telemetry.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
class SensorDataConsumerTest {
    @Test
    public void test() throws JsonProcessingException {
        log.info(SensorDataConsumer.getSensorDataFromString("{\"transactionId\":null,\"deviceId\":null,\"temperature\":null,\"humidity\":null,\"timestamp\":\"2024-12-19T00:12:19Z\"}").getTimestamp());
    }

}