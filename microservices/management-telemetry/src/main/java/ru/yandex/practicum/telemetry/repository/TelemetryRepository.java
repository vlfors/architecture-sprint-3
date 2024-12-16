package ru.yandex.practicum.telemetry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.telemetry.model.Telemetry;

import java.util.List;
import java.util.UUID;

public interface TelemetryRepository extends JpaRepository<Telemetry, UUID> {

    List<Telemetry> findByDeviceId(UUID deviceId);
    List<Telemetry> findByDeviceIdAndMetricType(UUID deviceId, String metricType);
}