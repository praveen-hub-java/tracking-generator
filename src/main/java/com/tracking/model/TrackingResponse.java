package com.tracking.model;

import lombok.Data;

/* 
 * Not used this class, we can make our project more generic with the help of 
 * Request and Response objects mappers instead of sending query paramters to service layer.
 */
@Data
public class TrackingResponse {

	private String tracking_number;
	private String created_at; // time at which tracking number is generated 
}
