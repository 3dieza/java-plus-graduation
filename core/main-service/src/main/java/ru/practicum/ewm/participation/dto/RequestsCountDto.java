package ru.practicum.ewm.participation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestsCountDto {
    private Long eventId;
    private Integer count;
}