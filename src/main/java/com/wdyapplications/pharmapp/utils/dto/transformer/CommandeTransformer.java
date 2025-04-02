

/*
 * Java transformer for entity table commande 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.utils.dto.CommandeDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static CommandeDto toDto(Commande entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		CommandeDto dto = new CommandeDto();
		dto.setId(entity.getId());
		dto.setAssuranceId(entity.getAssurances().getId());
		dto.setAdresseId(entity.getAdresse().getId());
		dto.setModeRecuperation(entity.getModeRecuperation());
		dto.setPrixTotal(entity.getPrixTotal());
		dto.setOrdonnanceId(entity.getOrdonnance().getId());
		dto.setPharmacieId(entity.getPharmacie().getId());
		dto.setUserId(entity.getUsers().getId());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<CommandeDto> toDtos(List<Commande> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<CommandeDto> dtos = new ArrayList<>();
		for (Commande entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static CommandeDto toLiteDto(Commande entity) {
		if (entity == null) {
			return null;
		}
		CommandeDto dto = new CommandeDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<CommandeDto> toLiteDtos(List<Commande> entities) {
		if (entities == null) {
			return null;
		}
		List<CommandeDto> dtos = new ArrayList<>();
		for (Commande entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Commande toEntity(CommandeDto dto, Pharmacie pharmacie, Assurances assurances, Ordonnance ordonnance, Adresse adresse, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		Commande entity = new Commande();
		entity.setId(dto.getId());
		entity.setUsers(users);
		entity.setPharmacie(pharmacie);
		entity.setAssurances(assurances);
		entity.setOrdonnance(ordonnance);
		entity.setAdresse(adresse);
		entity.setModeRecuperation(dto.getModeRecuperation());
		entity.setPrixTotal(dto.getPrixTotal());
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
