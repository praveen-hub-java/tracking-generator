package com.teleport.tracking.dto;

import jakarta.validation.constraints.*;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TrackingRequest(
    @Size(min = 2, max = 2) String origin_country_id,
    @Size(min = 2, max = 2) String destination_country_id,
    @DecimalMin("0.0") @Digits(integer = 5, fraction = 3) Double weight,
    @NotNull OffsetDateTime created_at,
    @NotNull UUID customer_id,
    @NotBlank String customer_name,
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$") String customer_slug
) {}
