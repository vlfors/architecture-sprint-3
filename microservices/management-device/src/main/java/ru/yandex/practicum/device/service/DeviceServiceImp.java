package ru.yandex.practicum.device.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.device.dto.Device;
import ru.yandex.practicum.device.dto.DeviceCreate;
import ru.yandex.practicum.device.dto.DeviceStatus;
import ru.yandex.practicum.device.repository.DeviceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImp implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> getDeviceById(UUID id) {
        return deviceRepository.findById(id);
    }

    @Override
    public Device createDevice(DeviceCreate deviceCreate) {
        Device device = new Device();
        device.setTransactionId(deviceCreate.getTransactionId());
        device.setId(UUID.randomUUID());
        device.setTypeId(deviceCreate.getTypeId());
        device.setHouseId(deviceCreate.getHouseId());
        device.setName(deviceCreate.getName());
        device.setSerialNumber(deviceCreate.getSerialNumber());
        device.setStatus(deviceCreate.getStatus());
        device.setCreatedAt(LocalDateTime.now());
        return deviceRepository.save(device);
    }


    @Override
    public Device updateDeviceStatus(UUID deviceId, DeviceStatus statusUpdate) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + deviceId));

        device.setStatus(statusUpdate.getStatus());
        device.setTransactionId(statusUpdate.getTransactionId());

        return deviceRepository.save(device);
    }

}