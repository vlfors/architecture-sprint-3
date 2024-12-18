package ru.yandex.practicum.telemetry.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.practicum.telemetry.dto.Common;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "telemetry")
public class Telemetry extends Common {
    @Id
    private UUID id;
    @Column(name = "device_id")
    private UUID deviceId;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    @Column(name = "metric_type")
    private String metricType;
    @Column(name = "value")
    private Double value;
}
