package com.teleport.tracking.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.teleport.tracking.model.TrackingNumber;

import reactor.core.publisher.Mono;

public interface TrackingNumberRepository extends ReactiveCrudRepository<TrackingNumber, Long> {
    Mono<Boolean> existsByTrackingNumber(String trackingNumber);
}
