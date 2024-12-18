package ru.yandex.practicum.device.service;

import ru.yandex.practicum.device.dto.Device;
import ru.yandex.practicum.device.dto.DeviceCreate;
import ru.yandex.practicum.device.dto.DeviceStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeviceService {
    List<Device> getAllDevices();
    Optional<Device> getDeviceById(UUID id);
    Device createDevice(DeviceCreate deviceCreate);
    Device updateDeviceStatus(UUID deviceId, DeviceStatus statusUpdate);
}
