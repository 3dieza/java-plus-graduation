package ru.practicum.ewm.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.ewm.dto.CategoryDtoOut;
import ru.practicum.ewm.dto.EventCreateDto;
import ru.practicum.ewm.dto.EventDtoOut;
import ru.practicum.ewm.dto.EventShortDtoOut;
import ru.practicum.ewm.dto.LocationDto;
import ru.practicum.ewm.dto.LocationFullDtoOut;
import ru.practicum.ewm.dto.UserDtoOut;
import ru.practicum.ewm.model.Event;

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
                .categoryId(eventDto.getCategoryId())
                .build();
    }

    public EventDtoOut toDto(Event event,
                             CategoryDtoOut category,
                             UserDtoOut initiator,
                             LocationDto location) {
        return EventDtoOut.builder()
                .id(event.getId())
                .annotation(event.getAnnotation())
                .title(event.getTitle())
                .category(category)
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

    public EventShortDtoOut toShortDto(Event event,
                                       CategoryDtoOut category,
                                       UserDtoOut initiator) {
        return EventShortDtoOut.builder()
                .id(event.getId())
                .annotation(event.getAnnotation())
                .title(event.getTitle())
                .category(category)
                .paid(event.getPaid())
                .eventDate(event.getEventDate())
                .initiator(initiator)
                .confirmedRequests(event.getConfirmedRequests())
                .views(event.getViews())
                .build();
    }

    public EventDtoOut toDto(Event event, UserDtoOut initiator, LocationDto location) {
        return toDto(event, null, initiator, location);
    }

    public EventShortDtoOut toShortDto(Event event, UserDtoOut initiator) {
        return toShortDto(event, null, initiator);
    }

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