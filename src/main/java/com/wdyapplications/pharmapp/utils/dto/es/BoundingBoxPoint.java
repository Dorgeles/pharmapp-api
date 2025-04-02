package com.wdyapplications.pharmapp.utils.dto.es;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BoundingBoxPoint {
	private String lat;
	private String lon;
	
	public BoundingBoxPoint(String lat, String lon) {
		this.lat = lat;
		this.lon = lon;
	}
}
