package ru.yandex.practicum.device.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Device extends Common {
    @Id
    private UUID id;
    private UUID typeId;
    private UUID houseId;
    private String name;
    private String serialNumber;
    private String status;
    private LocalDateTime createdAt;

}