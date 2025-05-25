package com.teleport.tracking.service;



import com.teleport.tracking.dto.TrackingRequest;
import com.teleport.tracking.dto.TrackingResponse;
import com.teleport.tracking.model.TrackingNumber;
import com.teleport.tracking.repository.TrackingNumberRepository;
import com.teleport.tracking.util.TrackingNumberGenerator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

@Service
public class TrackingService {

    private final TrackingNumberRepository repository;

    public TrackingService(TrackingNumberRepository repository) {
        this.repository = repository;
    }

    public Mono<TrackingResponse> generateTrackingNumber(TrackingRequest request) {
        return tryGenerateUnique(0)
            .flatMap(tracking -> {
                TrackingNumber record = new TrackingNumber();
                record.setTrackingNumber(tracking);
                record.setCreatedAt(OffsetDateTime.now());
                return repository.save(record)
                        .map(saved -> new TrackingResponse(saved.getTrackingNumber(), saved.getCreatedAt()));
            });
    }

    private Mono<String> tryGenerateUnique(int attempt) {
        if (attempt > 5) return Mono.error(new RuntimeException("Failed to generate unique tracking number"));

        String generated = TrackingNumberGenerator.generate(12);
        return repository.existsByTrackingNumber(generated)
                .flatMap(exists -> exists ? tryGenerateUnique(attempt + 1) : Mono.just(generated));
    }
}
