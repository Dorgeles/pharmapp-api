

/*
 * Java transformer for entity table user_preferences 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.UserPreferences;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.UserPreferencesDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPreferencesTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static UserPreferencesDto toDto(UserPreferences entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		UserPreferencesDto dto = new UserPreferencesDto();
		dto.setId(entity.getId());
		dto.setPreferenceKey(entity.getPreferenceKey());
		dto.setPreferenceValue(entity.getPreferenceValue());
		dto.setUserId(entity.getUsers().getId());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<UserPreferencesDto> toDtos(List<UserPreferences> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<UserPreferencesDto> dtos = new ArrayList<>();
		for (UserPreferences entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static UserPreferencesDto toLiteDto(UserPreferences entity) {
		if (entity == null) {
			return null;
		}
		UserPreferencesDto dto = new UserPreferencesDto();
		dto.setId(entity.getId());
		return dto;
	}

	public static List<UserPreferencesDto> toLiteDtos(List<UserPreferences> entities) {
		if (entities == null) {
			return null;
		}
		List<UserPreferencesDto> dtos = new ArrayList<>();
		for (UserPreferences entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static UserPreferences toEntity(UserPreferencesDto dto, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		UserPreferences entity = new UserPreferences();
		entity.setId(dto.getId());
		entity.setPreferenceKey(dto.getPreferenceKey());
		entity.setPreferenceValue(dto.getPreferenceValue());
		entity.setUsers(users);
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setDeletedAt(parseDate(dto.getDeletedAt()));
		entity.setIsDeleted(dto.getIsDeleted());
		entity.setStatusId(dto.getStatusId());
		entity.setUpdatedAt(parseDate(dto.getUpdatedAt()));
		entity.setCreatedAt(parseDate(dto.getCreatedAt()));
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
