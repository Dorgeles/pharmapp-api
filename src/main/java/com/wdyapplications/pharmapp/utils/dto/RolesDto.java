
/*
 * Java dto for entity table roles 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.base._RolesDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO for table "roles"
 *
 * @author Geo
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class RolesDto extends _RolesDto{

    private String    statusLibelle               ;

	public String getStatusLibelle() {
		return statusLibelle;
	}

	public void setStatusLibelle(String statusLibelle) {
		this.statusLibelle = statusLibelle;
	}
    
	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
