package ru.yandex.practicum.device.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.device.dto.Device;
import ru.yandex.practicum.device.dto.DeviceCreate;
import ru.yandex.practicum.device.dto.DeviceStatus;
import ru.yandex.practicum.device.service.DeviceServiceImp;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceServiceImp deviceService;

    @GetMapping
    public ResponseEntity<List<Device>> getDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody DeviceCreate deviceCreate) {
        Device device = deviceService.createDevice(deviceCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> getDeviceById(@PathVariable UUID deviceId) {

        Device device = deviceService.getDeviceById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        return ResponseEntity.ok(device);

    }

    @PutMapping("/{deviceId}/status")
    public ResponseEntity<Device> updateDeviceStatus(@PathVariable UUID deviceId, @RequestBody DeviceStatus deviceUpdate) {
        Device device = deviceService.updateDeviceStatus(deviceId, deviceUpdate );
        return ResponseEntity.ok(device);
    }
}