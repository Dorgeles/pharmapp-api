

/*
 * Java transformer for entity table users 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.UsersDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static UsersDto toDto(Users entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		UsersDto dto = new UsersDto();
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		dto.setEmail(entity.getEmail());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<UsersDto> toDtos(List<Users> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<UsersDto> dtos = new ArrayList<>();
		for (Users entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static UsersDto toLiteDto(Users entity) {
		if (entity == null) {
			return null;
		}
		UsersDto dto = new UsersDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<UsersDto> toLiteDtos(List<Users> entities) {
		if (entities == null) {
			return null;
		}
		List<UsersDto> dtos = new ArrayList<>();
		for (Users entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Users toEntity(UsersDto dto) throws ParseException {
		if (dto == null) {
			return null;
		}
		Users entity = new Users();
		entity.setId(dto.getId());
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setEmail(dto.getEmail());
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setDeletedAt(parseDate(dto.getDeletedAt()));
		entity.setIsDeleted(dto.getIsDeleted());
		entity.setCreatedAt(parseDate(dto.getCreatedAt()));
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
