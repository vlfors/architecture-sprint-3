package ru.yandex.practicum.device.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceCommand extends Common {

    private Integer deviceId;
    private String command;

}
