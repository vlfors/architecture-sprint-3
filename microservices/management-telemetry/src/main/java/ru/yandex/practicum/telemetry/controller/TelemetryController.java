package ru.yandex.practicum.telemetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.telemetry.dto.Telemetry;
import ru.yandex.practicum.telemetry.service.TelemetryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;

    @GetMapping("/{deviceId}/")
    public ResponseEntity<List<Telemetry>> getTelemetryData(@PathVariable UUID deviceId) {
        List<Telemetry> telemetryList = telemetryService.getTelemetryData(deviceId);
        return ResponseEntity.ok(telemetryList);
    }

    @GetMapping("/{deviceId}/temperature")
    public ResponseEntity<List<Telemetry>> getTemperatureTelemetry(@PathVariable UUID deviceId) {
        // Mock response
        List<Telemetry> telemetryList = new ArrayList<>();
        Telemetry telemetry = new Telemetry();
        telemetry.setId(UUID.randomUUID());
        telemetry.setDeviceId(deviceId);
        telemetry.setTimestamp(LocalDateTime.now());
        telemetry.setData(Map.of("temperature", 22.5));
        telemetryList.add(telemetry);

        return ResponseEntity.ok(telemetryList);
    }

    @PostMapping("/{deviceId}")
    public ResponseEntity<Telemetry> createTelemetry(@PathVariable UUID deviceId, @RequestBody Map<String, Object> data) {
        Telemetry telemetry = telemetryService.createTelemetry(deviceId, data);
        return ResponseEntity.ok(telemetry);
    }
}
