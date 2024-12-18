package ru.yandex.practicum.telemetry.dto;

import java.util.Map;

public class TelemetryDto  extends Common {
    Map<String, Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}