package ru.yandex.practicum.telemetry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.telemetry.dto.SensorData;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class SensorDataControllerTest {

    @Test
    public void test() throws JsonProcessingException {
        SensorData data = new SensorData();
        data.setTimestamp(LocalDateTime.now());
        SensorDataController.toString(data);
        log.warn(SensorDataController.toString(data));
    }
}