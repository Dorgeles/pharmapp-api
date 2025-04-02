

/*
 * Java transformer for entity table ordonnance 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Ordonnance;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.OrdonnanceDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdonnanceTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static OrdonnanceDto toDto(Ordonnance entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		OrdonnanceDto dto = new OrdonnanceDto();
		dto.setId(entity.getId());
		dto.setDateEmission(entity.getDateEmission());
		dto.setImageUrl(entity.getImageUrl());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUserId(entity.getUsers().getId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<OrdonnanceDto> toDtos(List<Ordonnance> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<OrdonnanceDto> dtos = new ArrayList<>();
		for (Ordonnance entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static OrdonnanceDto toLiteDto(Ordonnance entity) {
		if (entity == null) {
			return null;
		}
		OrdonnanceDto dto = new OrdonnanceDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<OrdonnanceDto> toLiteDtos(List<Ordonnance> entities) {
		if (entities == null) {
			return null;
		}
		List<OrdonnanceDto> dtos = new ArrayList<>();
		for (Ordonnance entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Ordonnance toEntity(OrdonnanceDto dto, Users user) throws ParseException {
		if (dto == null) {
			return null;
		}
		Ordonnance entity = new Ordonnance();
		entity.setId(dto.getId());
		entity.setUsers(user);
		entity.setDateEmission(dto.getDateEmission());
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
