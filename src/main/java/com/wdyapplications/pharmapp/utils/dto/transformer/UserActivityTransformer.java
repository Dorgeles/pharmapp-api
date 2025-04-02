

/*
 * Java transformer for entity table user_activity 
 * Created on 2024-11-09 ( Time 14:22:13 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.UserActivity;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.UserActivityDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserActivityTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static UserActivityDto toDto(UserActivity entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		UserActivityDto dto = new UserActivityDto();
		dto.setId(entity.getId());
		dto.setActivityType(entity.getActivityType());
		dto.setRemoteIp(entity.getRemoteIp());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setUserId(entity.getUsers().getId());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<UserActivityDto> toDtos(List<UserActivity> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<UserActivityDto> dtos = new ArrayList<>();
		for (UserActivity entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static UserActivityDto toLiteDto(UserActivity entity) {
		if (entity == null) {
			return null;
		}
		UserActivityDto dto = new UserActivityDto();
		dto.setId(entity.getId());
		dto.setActivityType(entity.getActivityType());
		dto.setRemoteIp(entity.getRemoteIp());
		return dto;
	}

	public static List<UserActivityDto> toLiteDtos(List<UserActivity> entities) {
		if (entities == null) {
			return null;
		}
		List<UserActivityDto> dtos = new ArrayList<>();
		for (UserActivity entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static UserActivity toEntity(UserActivityDto dto, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		UserActivity entity = new UserActivity();
		entity.setId(dto.getId());
		entity.setUsers(users);
		entity.setActivityType(dto.getActivityType());
		entity.setRemoteIp(dto.getRemoteIp());
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
