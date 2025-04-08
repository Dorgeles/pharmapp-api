

/*
 * Java transformer for entity table prix_medicament 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Medicament;
import com.wdyapplications.pharmapp.dao.entity.Pharmacie;
import com.wdyapplications.pharmapp.dao.entity.PrixMedicament;
import com.wdyapplications.pharmapp.utils.dto.PrixMedicamentDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrixMedicamentTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static PrixMedicamentDto toDto(PrixMedicament entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		PrixMedicamentDto dto = new PrixMedicamentDto();
		dto.setId(entity.getId());
		dto.setPrixUnitaire(entity.getPrixUnitaire());
		dto.setPharmacieId(entity.getPharmacie().getId());
		dto.setMedicamentId(entity.getMedicament().getId());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<PrixMedicamentDto> toDtos(List<PrixMedicament> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<PrixMedicamentDto> dtos = new ArrayList<>();
		for (PrixMedicament entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static PrixMedicamentDto toLiteDto(PrixMedicament entity) {
		if (entity == null) {
			return null;
		}
		PrixMedicamentDto dto = new PrixMedicamentDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<PrixMedicamentDto> toLiteDtos(List<PrixMedicament> entities) {
		if (entities == null) {
			return null;
		}
		List<PrixMedicamentDto> dtos = new ArrayList<>();
		for (PrixMedicament entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static PrixMedicament toEntity(PrixMedicamentDto dto, Pharmacie pharmacie, Medicament medicament) throws ParseException {
		if (dto == null) {
			return null;
		}
		PrixMedicament entity = new PrixMedicament();
		entity.setId(dto.getId());
		entity.setMedicament(medicament);
		entity.setPharmacie(pharmacie);
		entity.setPrixUnitaire(dto.getPrixUnitaire());
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setDeletedAt(parseDate(dto.getDeletedAt()));
		entity.setIsDeleted(dto.getIsDeleted());
		entity.setStatusId(dto.getStatusId());
		entity.setCreatedAt(parseDate(dto.getCreatedAt()));
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
