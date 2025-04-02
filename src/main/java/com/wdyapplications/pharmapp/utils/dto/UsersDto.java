
/*
 * Java dto for entity table users 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.base._UsersDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * DTO for table "users"
 *
 * @author Geo
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class UsersDto extends _UsersDto{

    private String    statusLibelle               ;

	public String getStatusLibelle() {
		return statusLibelle;
	}
	public void setStatusLibelle(String statusLibelle) {
		this.statusLibelle = statusLibelle;
	}
	private List<RolesDto> dataRoles                      ;
	private List<UserProfileDto> dataProfiles                      ;
	private List<AdresseDto> dataAdresses                      ;
	private List<AssurancesDto> dataAssurances                      ;
	private String token;

	public List<RolesDto> getDataRoles() {
		return dataRoles;
	}

	public void setDataRoles(List<RolesDto> dataRoles) {
		this.dataRoles = dataRoles;
	}

	public List<UserProfileDto> getDataProfiles() {
		return dataProfiles;
	}

	public void setDataProfiles(List<UserProfileDto> dataProfiles) {
		this.dataProfiles = dataProfiles;
	}

	public List<AdresseDto> getDataAdresses() {
		return dataAdresses;
	}

	public void setDataAdresses(List<AdresseDto> dataAdresses) {
		this.dataAdresses = dataAdresses;
	}

	public List<AssurancesDto> getDataAssurances() {
		return dataAssurances;
	}

	public void setDataAssurances(List<AssurancesDto> dataAssurances) {
		this.dataAssurances = dataAssurances;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	private String oldPassword;

	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
