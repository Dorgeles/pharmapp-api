

/*
 * Java transformer for entity table adresse 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Adresse;
import com.wdyapplications.pharmapp.dao.entity.Adresse;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.AdresseDto;
import com.wdyapplications.pharmapp.utils.dto.AdresseDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdresseTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static AdresseDto toDto(Adresse entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		AdresseDto dto = new AdresseDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}


	public static List<AdresseDto> toDtos(List<Adresse> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<AdresseDto> dtos = new ArrayList<>();
		for (Adresse entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static AdresseDto toLiteDto(Adresse entity) {
		if (entity == null) {
			return null;
		}
		AdresseDto dto = new AdresseDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		return dto;
	}

	public static List<AdresseDto> toLiteDtos(List<Adresse> entities) {
		if (entities == null) {
			return null;
		}
		List<AdresseDto> dtos = new ArrayList<>();
		for (Adresse entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Adresse toEntity(AdresseDto dto, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		Adresse entity = new Adresse();
		entity.setId(dto.getId());
		entity.setUsers(users);
		entity.setLibelle(dto.getLibelle());
		entity.setCreatedAt(parseDate(dto.getCreatedAt()));
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setDeletedAt(parseDate(dto.getDeletedAt()));
		entity.setIsDeleted(dto.getIsDeleted());
		entity.setStatusId(dto.getStatusId());
		entity.setUpdatedAt(parseDate(dto.getUpdatedAt()));
		entity.setUpdatedBy(dto.getUpdatedBy());
		return entity;
	}

	private static String formatDate(Date date) {
		return (date != null) ? DATE_FORMAT.format(date) : null;
	}

	private static Date parseDate(String dateStr) throws ParseException {
		return (dateStr != null && !dateStr.isEmpty()) ? DATE_FORMAT.parse(dateStr) : null;
	}

}
