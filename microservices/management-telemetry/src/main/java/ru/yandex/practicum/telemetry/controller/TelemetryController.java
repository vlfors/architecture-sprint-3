package ru.yandex.practicum.telemetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.telemetry.dto.TelemetryDto;
import ru.yandex.practicum.telemetry.model.Telemetry;
import ru.yandex.practicum.telemetry.service.TelemetryService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;

    @GetMapping("/{deviceId}")
    public ResponseEntity<List<Telemetry>> getTelemetryData(@PathVariable UUID deviceId) {
        List<Telemetry> telemetryList = telemetryService.getTelemetryData(deviceId);
        return ResponseEntity.ok(telemetryList);
    }

    @GetMapping("/{deviceId}/temperature")
    public ResponseEntity<List<Telemetry>> getTemperatureTelemetry(@PathVariable UUID deviceId) {
        List<Telemetry> telemetryList = telemetryService.getTemperatureTelemetry(deviceId);
        return ResponseEntity.ok(telemetryList);
    }

    @PostMapping("/{deviceId}")
    public ResponseEntity<Telemetry> createTelemetry(@PathVariable UUID deviceId, @RequestBody TelemetryDto telemetryDto) {
        Telemetry telemetry = telemetryService.createTelemetry(deviceId, telemetryDto);
        return ResponseEntity.ok(telemetry);
    }
}
