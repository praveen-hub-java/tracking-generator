package com.tracking.model;

import lombok.Getter;
import lombok.Setter;

/* 
 * Not used this class, we can make our project more generic with the help of 
 * Request and Response objects mappers instead of sending query paramters to service layer.
 */

@Setter
@Getter
public class TrackingRequest {
	private String origin_country_id;
	private String destination_country_id;
	private float weight;
	private String customer_id;
	private String customer_name;
	private String customer_slug;

	@Override
	public String toString() {
		return "originID"+this.origin_country_id +" dest"+this.destination_country_id +"Baruvu"+this.weight +"CUSTID"+
				this.customer_id +"NAME"+this.customer_name +"SLUG"+this.customer_slug  ;
	}
}
