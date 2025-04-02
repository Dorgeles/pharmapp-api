

/*
 * Java transformer for entity table otp 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.transformer;
import com.wdyapplications.pharmapp.dao.entity.Otp;
import com.wdyapplications.pharmapp.utils.dto.OtpDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OtpTransformer {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static OtpDto toDto(Otp entity) throws ParseException {
		if (entity == null) {
			return null;
		}
		OtpDto dto = new OtpDto();
		dto.setId(entity.getId());
		dto.setCodeOtp(entity.getCodeOtp());
		dto.setExpired(entity.getExpired());
		dto.setIdentifier(entity.getIdentifier());
		dto.setOrigineElementId(entity.getOrigineElementId());
		dto.setToken(entity.getToken());
		dto.setExpireOn(formatDate(entity.getExpireOn()));
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

	public static List<OtpDto> toDtos(List<Otp> entities) throws ParseException {
		if (entities == null) {
			return null;
		}
		List<OtpDto> dtos = new ArrayList<>();
		for (Otp entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}

	public static OtpDto toLiteDto(Otp entity) {
		if (entity == null) {
			return null;
		}
		OtpDto dto = new OtpDto();
		dto.setId(entity.getId());
		dto.setToken(entity.getToken());
		dto.setCodeOtp(entity.getCodeOtp());
		return dto;
	}

	public static List<OtpDto> toLiteDtos(List<Otp> entities) {
		if (entities == null) {
			return null;
		}
		List<OtpDto> dtos = new ArrayList<>();
		for (Otp entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	public static Otp toEntity(OtpDto dto) throws ParseException {
		if (dto == null) {
			return null;
		}
		Otp entity = new Otp();
		entity.setId(dto.getId());
		entity.setCodeOtp(dto.getCodeOtp());
		entity.setExpireOn(parseDate(dto.getExpireOn()));
		entity.setExpired(dto.getExpired());
		entity.setIdentifier(dto.getIdentifier());
		entity.setOrigineElementId(dto.getOrigineElementId());
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
