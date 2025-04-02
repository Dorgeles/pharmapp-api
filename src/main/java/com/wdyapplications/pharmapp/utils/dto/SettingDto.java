
/*
 * Java dto for entity table setting 
 * Created on 2024-11-16 ( Time 14:29:24 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.base._SettingDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

/**
 * DTO for table "setting"
 *
 * @author Geo
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class SettingDto extends _SettingDto{

    private String    statusLibelle               ;

	public String getStatusLibelle() {
		return statusLibelle;
	}

	public void setStatusLibelle(String statusLibelle) {
		this.statusLibelle = statusLibelle;
	}
	private Map<String, Object> jsonValue ;

	public Map<String, Object> getJsonValue() {
		return jsonValue;
	}

	public void setJsonValue(Map<String, Object> jsonValue) {
		this.jsonValue = jsonValue;
	}

	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
