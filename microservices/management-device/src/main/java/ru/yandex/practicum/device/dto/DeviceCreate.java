package ru.yandex.practicum.device.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class DeviceCreate extends Common  {
    @Id
    private UUID id;
    private UUID typeId;
    private UUID houseId;
    private String name;
    private String serialNumber;
    private String status;
}
