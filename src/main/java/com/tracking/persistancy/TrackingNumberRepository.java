package com.tracking.persistancy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tracking.model.TrackingTable;


@Repository
public interface TrackingNumberRepository extends CrudRepository<TrackingTable, Long> { 
	public TrackingTable findByTrackingnumber(String trackNumber);
}
