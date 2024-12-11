package ru.yandex.practicum.device.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Device extends Common {
    private UUID id;
    private UUID typeId;
    private UUID houseId;
    private String name;
    private String serialNumber;
    private String status;
    private LocalDateTime createdAt;

}