

/*
 * Java transformer for entity table user_UserRoles 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Roles;
import com.wdyapplications.pharmapp.dao.entity.UserRoles;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.UserRolesDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRolesTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static UserRolesDto toDto(UserRoles entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		UserRolesDto dto = new UserRolesDto();
		dto.setId(entity.getId());
		dto.setRoleId(entity.getRoles().getId());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setUserId(entity.getUsers().getId());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<UserRolesDto> toDtos(List<UserRoles> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<UserRolesDto> dtos = new ArrayList<>();
		for (UserRoles entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static UserRolesDto toLiteDto(UserRoles entity) {
		if (entity == null) {
			return null;
		}
		UserRolesDto dto = new UserRolesDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<UserRolesDto> toLiteDtos(List<UserRoles> entities) {
		if (entities == null) {
			return null;
		}
		List<UserRolesDto> dtos = new ArrayList<>();
		for (UserRoles entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static UserRoles toEntity(UserRolesDto dto, Roles roles, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		UserRoles entity = new UserRoles();
		entity.setId(dto.getId());
		entity.setRoles(roles);
		entity.setUsers(users);
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
