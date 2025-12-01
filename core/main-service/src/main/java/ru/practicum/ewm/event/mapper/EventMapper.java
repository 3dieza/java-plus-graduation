package ru.practicum.ewm.event.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.ewm.category.mapper.CategoryMapper;
import ru.practicum.ewm.event.dto.EventCreateDto;
import ru.practicum.ewm.event.dto.EventDtoOut;
import ru.practicum.ewm.event.dto.EventShortDtoOut;
import ru.practicum.ewm.event.model.Event;
import ru.practicum.ewm.dto.LocationDto;
import ru.practicum.ewm.dto.LocationFullDtoOut;
import ru.practicum.ewm.user.dto.UserDtoOut;

@UtilityClass
public class EventMapper {
    public Event fromDto(EventCreateDto eventDto) {
        return Event.builder()
                .annotation(eventDto.getAnnotation())
                .title(eventDto.getTitle())
                .paid(eventDto.getPaid())
                .eventDate(eventDto.getEventDate())
                .description(eventDto.getDescription())
                .participantLimit(eventDto.getParticipantLimit())
                .requestModeration(eventDto.getRequestModeration())
                .build();
    }

    public EventDtoOut toDto(Event event, UserDtoOut initiator, LocationDto location) {
        return EventDtoOut.builder()
                .id(event.getId())
                .annotation(event.getAnnotation())
                .title(event.getTitle())
                .category(CategoryMapper.toDto(event.getCategory()))
                .paid(event.getPaid())
                .eventDate(event.getEventDate())
                .description(event.getDescription())
                .initiator(initiator)
                .createdOn(event.getCreatedAt())
                .publishedOn(event.getPublishedOn())
                .state(event.getState())
                .confirmedRequests(event.getConfirmedRequests())
                .views(event.getViews())
                .participantLimit(event.getParticipantLimit())
                .requestModeration(event.getRequestModeration())
                .location(location)
                .build();
    }

    public EventDtoOut toDto(Event event, UserDtoOut initiator) {
        return toDto(event, initiator, null);
    }

    public EventShortDtoOut toShortDto(Event event, UserDtoOut initiator) {
        return EventShortDtoOut.builder()
                .id(event.getId())
                .annotation(event.getAnnotation())
                .title(event.getTitle())
                .category(CategoryMapper.toDto(event.getCategory()))
                .paid(event.getPaid())
                .eventDate(event.getEventDate())
                .initiator(initiator)
                .confirmedRequests(event.getConfirmedRequests())
                .views(event.getViews())
                .build();
    }

    public EventShortDtoOut toShortDto(Event event) {
        return toShortDto(event, null);
    }

    // маппер из Full DTO (из location-service) в короткий dto для события
    public LocationDto toShortDto(LocationFullDtoOut src) {
        if (src == null) {
            return null;
        }
        return LocationDto.builder()
                .id(src.getId())
                .latitude(src.getLatitude())
                .longitude(src.getLongitude())
                .build();
    }
}