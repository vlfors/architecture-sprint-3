package ru.yandex.practicum.device.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class DeviceCreate extends Common  {
    private UUID typeId;
    private UUID houseId;
    private String name;
    private String serialNumber;
    private String status;
}
