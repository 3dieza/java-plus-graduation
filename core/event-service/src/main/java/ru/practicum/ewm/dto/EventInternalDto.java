package ru.practicum.ewm.dto;


import lombok.Data;
import ru.practicum.ewm.model.EventState;

@Data
public class EventInternalDto {
    private Long id;
    private Long initiatorId;
    private EventState state;
    private Integer participantLimit;
    private Boolean requestModeration;
}