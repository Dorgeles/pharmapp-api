

/*
 * Java transformer for entity table pharmacie 
 * Created on 2024-12-13 ( Time 15:54:44 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Pharmacie;
import com.wdyapplications.pharmapp.utils.dto.PharmacieDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PharmacieTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static PharmacieDto toDto(Pharmacie entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		PharmacieDto dto = new PharmacieDto();
		dto.setId(entity.getId());
		dto.setNom(entity.getNom());
		dto.setAdresse(entity.getAdresse());
		dto.setLatitude(entity.getLatitude());
		dto.setLongitude(entity.getLongitude());
		dto.setTelephone(entity.getTelephone());
		dto.setEmail(entity.getEmail());
		dto.setHorairesOuverture(entity.getHorairesOuverture());
		dto.setImagesUrl(entity.getImagesUrl());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<PharmacieDto> toDtos(List<Pharmacie> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<PharmacieDto> dtos = new ArrayList<>();
		for (Pharmacie entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static PharmacieDto toLiteDto(Pharmacie entity) {
		if (entity == null) {
			return null;
		}
		PharmacieDto dto = new PharmacieDto();
		dto.setId(entity.getId());
		dto.setNom(entity.getNom());
		return dto;
	}

	public static List<PharmacieDto> toLiteDtos(List<Pharmacie> entities) {
		if (entities == null) {
			return null;
		}
		List<PharmacieDto> dtos = new ArrayList<>();
		for (Pharmacie entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Pharmacie toEntity(PharmacieDto dto) throws ParseException {
		if (dto == null) {
			return null;
		}
		Pharmacie entity = new Pharmacie();
		entity.setId(dto.getId());
		entity.setNom(dto.getNom());
		entity.setAdresse(dto.getAdresse());
		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());
		entity.setEmail(dto.getEmail());
		entity.setTelephone(dto.getTelephone());
		entity.setHorairesOuverture(dto.getHorairesOuverture());
		entity.setImagesUrl(dto.getImagesUrl());
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
