

/*
 * Java transformer for entity table ordonnance_medicament 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Medicament;
import com.wdyapplications.pharmapp.dao.entity.Ordonnance;
import com.wdyapplications.pharmapp.dao.entity.OrdonnanceMedicament;
import com.wdyapplications.pharmapp.utils.dto.OrdonnanceMedicamentDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdonnanceMedicamentTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static OrdonnanceMedicamentDto toDto(OrdonnanceMedicament entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		OrdonnanceMedicamentDto dto = new OrdonnanceMedicamentDto();
		dto.setId(entity.getId());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setMedicamentId(entity.getMedicament().getId());
		dto.setOrdonnanceId(entity.getOrdonnance().getId());
		dto.setQuantite(entity.getQuantite());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<OrdonnanceMedicamentDto> toDtos(List<OrdonnanceMedicament> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<OrdonnanceMedicamentDto> dtos = new ArrayList<>();
		for (OrdonnanceMedicament entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static OrdonnanceMedicamentDto toLiteDto(OrdonnanceMedicament entity) {
		if (entity == null) {
			return null;
		}
		OrdonnanceMedicamentDto dto = new OrdonnanceMedicamentDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<OrdonnanceMedicamentDto> toLiteDtos(List<OrdonnanceMedicament> entities) {
		if (entities == null) {
			return null;
		}
		List<OrdonnanceMedicamentDto> dtos = new ArrayList<>();
		for (OrdonnanceMedicament entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static OrdonnanceMedicament toEntity(OrdonnanceMedicamentDto dto, Medicament medicament,Ordonnance ordonnance) throws ParseException {
		if (dto == null) {
			return null;
		}
		OrdonnanceMedicament entity = new OrdonnanceMedicament();
		entity.setId(dto.getId());
		entity.setQuantite(dto.getQuantite());
		entity.setMedicament(medicament);
		entity.setOrdonnance(ordonnance);
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
