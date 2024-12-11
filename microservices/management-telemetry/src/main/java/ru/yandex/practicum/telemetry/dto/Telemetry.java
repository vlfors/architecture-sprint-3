package ru.yandex.practicum.telemetry.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Telemetry extends Common {
    private UUID id;
    private UUID deviceId;
    private LocalDateTime timestamp;
    private Map<String, Object> data;
}
