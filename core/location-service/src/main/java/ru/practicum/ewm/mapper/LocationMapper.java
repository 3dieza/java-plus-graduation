package ru.practicum.ewm.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.ewm.dto.LocationCreateDto;
import ru.practicum.ewm.dto.LocationDtoOut;
import ru.practicum.ewm.dto.LocationFullDtoOut;
import ru.practicum.ewm.dto.LocationPrivateDtoOut;
import ru.practicum.ewm.model.Location;

@UtilityClass
public class LocationMapper {
    public static Location fromDto(LocationCreateDto dto) {
        return Location.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }

    public static LocationDtoOut toDto(Location location) {
        return LocationDtoOut.builder()
                .id(location.getId())
                .name(location.getName())
                .address(location.getAddress())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }

    public static LocationFullDtoOut toFullDto(Location location) {
        return LocationFullDtoOut.builder()
                .id(location.getId())
                .name(location.getName())
                .address(location.getAddress())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .creatorId(location.getCreatorId())
                .state(location.getState())
                .build();
    }

    public static LocationPrivateDtoOut toPrivateDto(Location location) {
        return LocationPrivateDtoOut.builder()
                .id(location.getId())
                .name(location.getName())
                .address(location.getAddress())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .state(location.getState())
                .build();
    }
}
