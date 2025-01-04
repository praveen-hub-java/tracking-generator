package com.tracking.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tracking.model.TrackingTable;
import com.tracking.persistancy.TrackingNumberRepository;

@Service
public class TrackingNumberGenerator {
	
	@Autowired
	private  TrackingNumberRepository trackRepo;

	@Transactional
	public TrackingTable generateTrackingID(String originCD, String destCD, float weight,
			String createdAt,String customerId, String customerName,String customerSlug) {
		System.out.println(createdAt);
		
		return GenerateTrackAndSave();
	}

	public TrackingTable GenerateTrackAndSave() {
		
		String generatedString = this.generateTrackId();
		if(null == trackRepo.findByTrackingnumber(generatedString)) {;
			return saveToEntity(generatedString);
		}else {
			return GenerateTrackAndSave();
		}
	}

	// logic to generate tracking number in compliance with 
	//RE : 
	// Unique: ^[A-Z0-9]{1,16}$.
	public String generateTrackId() {
		Random random = new Random();
		int lowerStart = 48; // numeral '0'(0-9) will be covered from 48 to 57
		int higherEnd = 122; // for letters
		int maxStringLength = 16;
		String generatedString = random.ints(lowerStart, higherEnd + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // allowing only digits and letters here using filter
				.limit(maxStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		System.out.println(generatedString);
		return generatedString;

	}

	//to save to DB table for future checks
	public TrackingTable saveToEntity(String generatedString) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		TrackingTable trackingObject = new TrackingTable();
		trackingObject.setCreated_at(timestamp);
		trackingObject.setTrackingnumber(generatedString);

		return trackRepo.save(trackingObject);
	}

}
