package com.wdyapplications.pharmapp.utils.dto.transformer;

import com.wdyapplications.pharmapp.dao.entity.Roles;
import com.wdyapplications.pharmapp.utils.dto.RolesDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RolesTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static RolesDto toDto(Roles entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		RolesDto dto = new RolesDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		dto.setCommentaire(entity.getCommentaire());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<RolesDto> toDtos(List<Roles> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<RolesDto> dtos = new ArrayList<>();
		for (Roles entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static RolesDto toLiteDto(Roles entity) {
		if (entity == null) {
			return null;
		}
		RolesDto dto = new RolesDto();
		dto.setId(entity.getId());
		dto.setLibelle(entity.getLibelle());
		return dto;
	}

	public static List<RolesDto> toLiteDtos(List<Roles> entities) {
		if (entities == null) {
			return null;
		}
		List<RolesDto> dtos = new ArrayList<>();
		for (Roles entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Roles toEntity(RolesDto dto) throws ParseException {
		if (dto == null) {
			return null;
		}
		Roles entity = new Roles();
		entity.setId(dto.getId());
		entity.setLibelle(dto.getLibelle());
		entity.setCommentaire(dto.getCommentaire());
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
