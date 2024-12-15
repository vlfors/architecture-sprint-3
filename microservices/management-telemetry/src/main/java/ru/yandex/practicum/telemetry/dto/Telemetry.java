package ru.yandex.practicum.telemetry.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Telemetry extends Common {
    private UUID id;
    private UUID deviceId;
    private LocalDateTime timestamp;
    private Map<String, Object> data;
}
