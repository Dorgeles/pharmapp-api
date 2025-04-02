
/*
 * Java dto for entity table adresse 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.base._AdresseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO for table "adresse"
 *
 * @author Geo
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class AdresseDto extends _AdresseDto{

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
