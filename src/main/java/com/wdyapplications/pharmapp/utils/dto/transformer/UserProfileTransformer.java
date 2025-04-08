

/*
 * Java transformer for entity table user_profile 
 * Created on 2024-11-19 ( Time 17:06:07 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.UserProfile;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.utils.dto.UserProfileDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserProfileTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static UserProfileDto toDto(UserProfile entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		UserProfileDto dto = new UserProfileDto();
		dto.setId(entity.getId());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setContact(entity.getContact());
		dto.setProfilePicture(entity.getProfilePicture());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setUserId(entity.getUsers().getId());
		dto.setStatusId(entity.getStatusId());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<UserProfileDto> toDtos(List<UserProfile> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<UserProfileDto> dtos = new ArrayList<>();
		for (UserProfile entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static UserProfileDto toLiteDto(UserProfile entity) {
		if (entity == null) {
			return null;
		}
		UserProfileDto dto = new UserProfileDto();
		dto.setId(entity.getId());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setProfilePicture(entity.getProfilePicture());
		return dto;
	}

	public static List<UserProfileDto> toLiteDtos(List<UserProfile> entities) {
		if (entities == null) {
			return null;
		}
		List<UserProfileDto> dtos = new ArrayList<>();
		for (UserProfile entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static UserProfile toEntity(UserProfileDto dto, Users users) throws ParseException {
		if (dto == null) {
			return null;
		}
		UserProfile entity = new UserProfile();
		entity.setId(dto.getId());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		entity.setUsers(users);
		entity.setContact(dto.getContact());
		entity.setProfilePicture(dto.getProfilePicture());
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
