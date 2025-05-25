package com.teleport.tracking.controller;


import com.teleport.tracking.dto.TrackingRequest;
import com.teleport.tracking.dto.TrackingResponse;
import com.teleport.tracking.service.TrackingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackingController {

    private final TrackingService service;

    public TrackingController(TrackingService service) {
        this.service = service;
    }

    @GetMapping
    public Mono<TrackingResponse> getTrackingNumber(@Valid @ModelAttribute TrackingRequest request) {
        return service.generateTrackingNumber(request);
    }
}
