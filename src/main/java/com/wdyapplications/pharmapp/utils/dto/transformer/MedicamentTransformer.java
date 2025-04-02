

/*
 * Java transformer for entity table medicament 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Medicament;
import com.wdyapplications.pharmapp.utils.dto.MedicamentDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicamentTransformer {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static MedicamentDto toDto(Medicament entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		MedicamentDto dto = new MedicamentDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		dto.setDosage(entity.getDosage());
		dto.setFormePharmaceutique(entity.getFormePharmaceutique());
		dto.setPlafondPrix(entity.getPlafondPrix());
		dto.setPrincipeActif(entity.getPrincipeActif());
		dto.setLaboratoire(entity.getLaboratoire());
		dto.setDescription(entity.getDescription());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<MedicamentDto> toDtos(List<Medicament> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<MedicamentDto> dtos = new ArrayList<>();
		for (Medicament entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static MedicamentDto toLiteDto(Medicament entity) {
		if (entity == null) {
			return null;
		}
		MedicamentDto dto = new MedicamentDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		return dto;
	}

	public static List<MedicamentDto> toLiteDtos(List<Medicament> entities) {
		if (entities == null) {
			return null;
		}
		List<MedicamentDto> dtos = new ArrayList<>();
		for (Medicament entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Medicament toEntity(MedicamentDto dto) throws ParseException {
		if (dto == null) {
			return null;
		}
		Medicament entity = new Medicament();
		entity.setId(dto.getId());
		entity.setLibelle(dto.getLibelle());
		entity.setDosage(dto.getDosage());
		entity.setFormePharmaceutique(dto.getFormePharmaceutique());
		entity.setPlafondPrix(dto.getPlafondPrix());
		entity.setPrincipeActif(dto.getPrincipeActif());
		entity.setLaboratoire(dto.getLaboratoire());
		entity.setDescription(dto.getDescription());
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
