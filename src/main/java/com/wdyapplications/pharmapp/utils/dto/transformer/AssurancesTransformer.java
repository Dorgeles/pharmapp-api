

/*
 * Java transformer for entity table assurances 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Assurances;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.AssurancesDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssurancesTransformer {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static AssurancesDto toDto(Assurances entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		AssurancesDto dto = new AssurancesDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		dto.setMetaData(entity.getMetaData());
		dto.setImageUrl(entity.getImageUrl());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<AssurancesDto> toDtos(List<Assurances> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<AssurancesDto> dtos = new ArrayList<>();
		for (Assurances entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static AssurancesDto toLiteDto(Assurances entity) {
		if (entity == null) {
			return null;
		}
		AssurancesDto dto = new AssurancesDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		return dto;
	}

	public static List<AssurancesDto> toLiteDtos(List<Assurances> entities) {
		if (entities == null) {
			return null;
		}
		List<AssurancesDto> dtos = new ArrayList<>();
		for (Assurances entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Assurances toEntity(AssurancesDto dto, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		Assurances entity = new Assurances();
		entity.setId(dto.getId());
		entity.setUsers(users);
		entity.setLibelle(dto.getLibelle());
		entity.setMetaData(dto.getMetaData());
		entity.setImageUrl(dto.getImageUrl());
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
