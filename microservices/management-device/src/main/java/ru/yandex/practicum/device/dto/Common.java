package ru.yandex.practicum.device.dto;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Common {
    private UUID transactionId;
}