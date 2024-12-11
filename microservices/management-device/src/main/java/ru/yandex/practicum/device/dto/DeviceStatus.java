package ru.yandex.practicum.device.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeviceStatus extends Common  {
    private Integer deviceId;
    private String status;
    private LocalDateTime timestamp;
}
