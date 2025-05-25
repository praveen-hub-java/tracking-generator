package com.teleport.tracking.dto;


import java.time.OffsetDateTime;

public record TrackingResponse(String tracking_number, OffsetDateTime created_at) {}
