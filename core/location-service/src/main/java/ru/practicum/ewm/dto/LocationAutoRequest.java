package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationAutoRequest {

    @NotNull
    @JsonProperty("lat")
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;

    @NotNull
    @JsonProperty("lon")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;
}