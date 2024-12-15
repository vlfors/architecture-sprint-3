package ru.yandex.practicum.telemetry.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Common {
    @Id
    private UUID transactionId;
}