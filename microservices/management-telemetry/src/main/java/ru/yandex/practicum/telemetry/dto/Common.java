package ru.yandex.practicum.telemetry.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Common {
    private UUID transactionId;
}