

/*
 * Java transformer for entity table setting 
 * Created on 2024-11-16 ( Time 14:29:24 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Setting;
import com.wdyapplications.pharmapp.utils.dto.SettingDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SettingTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static SettingDto toDto(Setting entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		SettingDto dto = new SettingDto();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setValeur(entity.getValeur());
		dto.setCreatedAt(formatDate(entity.getCreatedAt()));
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setDeletedAt(formatDate(entity.getDeletedAt()));
		dto.setIsDeleted(entity.getIsDeleted());
		dto.setStatusId(entity.getStatusId());
		dto.setUpdatedAt(formatDate(entity.getUpdatedAt()));
		dto.setUpdatedBy(entity.getUpdatedBy());
		return dto;
	}

	public static List<SettingDto> toDtos(List<Setting> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<SettingDto> dtos = new ArrayList<>();
		for (Setting entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static SettingDto toLiteDto(Setting entity) {
		if (entity == null) {
			return null;
		}
		SettingDto dto = new SettingDto();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setValeur(entity.getValeur());
		return dto;
	}

	public static List<SettingDto> toLiteDtos(List<Setting> entities) {
		if (entities == null) {
			return null;
		}
		List<SettingDto> dtos = new ArrayList<>();
		for (Setting entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Setting toEntity(SettingDto dto) throws ParseException {
		if (dto == null) {
			return null;
		}
		Setting entity = new Setting();
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setValeur(dto.getValeur());
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
