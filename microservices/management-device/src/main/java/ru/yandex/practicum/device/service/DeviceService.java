package ru.yandex.practicum.device.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.device.dto.Device;
import ru.yandex.practicum.device.dto.DeviceCreate;
import ru.yandex.practicum.device.repository.DeviceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(UUID id) {
        return deviceRepository.findById(id);
    }

    public Device createDevice(DeviceCreate deviceCreate) {
        Device device = new Device();
        device.setId(UUID.randomUUID());
        device.setTypeId(deviceCreate.getTypeId());
        device.setHouseId(deviceCreate.getHouseId());
        device.setName(deviceCreate.getName());
        device.setSerialNumber(deviceCreate.getSerialNumber());
        device.setStatus(deviceCreate.getStatus());
        device.setCreatedAt(LocalDateTime.now());
        return deviceRepository.save(device);
    }

    public Device updateDeviceStatus(UUID deviceId, String status) {
        Device device = deviceRepository.findById(deviceId).orElseThrow();
        device.setStatus(status);
        return deviceRepository.save(device);
    }
}