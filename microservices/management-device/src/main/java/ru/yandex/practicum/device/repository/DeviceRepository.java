package ru.yandex.practicum.device.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.device.dto.Device;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}