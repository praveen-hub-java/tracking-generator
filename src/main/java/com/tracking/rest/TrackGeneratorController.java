package com.tracking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.model.TrackingTable;
import com.tracking.service.TrackingNumberGenerator;

@RestController
public class TrackGeneratorController {
	
	@Autowired
	TrackingNumberGenerator trackingNumberGenerator;

	@GetMapping("/next-tracking-number")
	public ResponseEntity<TrackingTable> sayHello(@RequestParam(name = "origin_country_id") String originCD,
			@RequestParam(name = "destination_country_id") String destCD,
			@RequestParam(name = "weight") float weight,
			@RequestParam(name = "created_at") String createdAt,
			@RequestParam(name = "customer_id") String customerId,
			@RequestParam(name = "customer_name") String customerName,
			@RequestParam(name = "customer_slug") String customerSlug
			) {
		
		TrackingTable trackingResponse=trackingNumberGenerator.generateTrackingID(originCD, destCD, weight, createdAt, customerId, customerName, customerSlug);
		return ResponseEntity.ok(trackingResponse);
		
	}

	@GetMapping("/")
	String home() {
		return "Hello World!";
	}
}