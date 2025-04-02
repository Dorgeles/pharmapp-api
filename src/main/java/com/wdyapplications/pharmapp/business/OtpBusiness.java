                                                                    																
/*
 * Java business for entity table otp 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Otp;
import com.wdyapplications.pharmapp.dao.repository.*;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.contract.IBasicBusiness;
import com.wdyapplications.pharmapp.utils.contract.Request;
import com.wdyapplications.pharmapp.utils.contract.Response;
import com.wdyapplications.pharmapp.utils.dto.*;
import com.wdyapplications.pharmapp.utils.dto.transformer.*;
import com.wdyapplications.pharmapp.utils.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
BUSINESS for table "otp"
 * 
 * @author Geo
 *
 */

@Component
public class OtpBusiness implements IBasicBusiness<Request<OtpDto>, Response<OtpDto>> {

	private Response<OtpDto> response;
	@Autowired
	private OtpRepository otpRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;

	public OtpBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Otp by using OtpDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OtpDto> create(Request<OtpDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Otp-----");

		Response<OtpDto> response = new Response<OtpDto>();
		List<Otp>        items    = new ArrayList<Otp>();
			
		for (OtpDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("codeOtp", dto.getCodeOtp());
			fieldsToVerify.put("identifier", dto.getIdentifier());
			fieldsToVerify.put("origineElementId", dto.getOrigineElementId());
			fieldsToVerify.put("isExpired", dto.getIsExpired());
			fieldsToVerify.put("expireOn", dto.getExpireOn());
			fieldsToVerify.put("token", dto.getToken());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			fieldsToVerify.put("commentaire", dto.getCommentaire());
			fieldsToVerify.put("statusId", dto.getStatusId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if otp to insert do not exist
			Otp existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("otp id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
				Otp entityToSave = null;
			entityToSave = OtpTransformer.toEntity(dto);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Otp> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = otpRepository.saveAll((Iterable<Otp>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("otp", locale));
				response.setHasError(true);
				return response;
			}
			List<OtpDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OtpTransformer.toLiteDtos(itemsSaved) : OtpTransformer.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		// System.out.println("----end create Otp-----");
		return response;
	}

	/**
	 * update Otp by using OtpDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OtpDto> update(Request<OtpDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Otp-----");

		Response<OtpDto> response = new Response<OtpDto>();
		List<Otp>        items    = new ArrayList<Otp>();
			
		for (OtpDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la otp existe
			Otp entityToSave = null;
			entityToSave = otpRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("otp id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getCodeOtp())) {
				entityToSave.setCodeOtp(dto.getCodeOtp());
			}
			if (Utilities.notBlank(dto.getIdentifier())) {
				entityToSave.setIdentifier(dto.getIdentifier());
			}
			if (dto.getOrigineElementId() != null && dto.getOrigineElementId() > 0) {
				entityToSave.setOrigineElementId(dto.getOrigineElementId());
			}
			if (dto.getIsExpired() != null) {
				entityToSave.setIsExpired(dto.getIsExpired());
			}
			if (Utilities.notBlank(dto.getExpireOn())) {
				entityToSave.setExpireOn(dateFormat.parse(dto.getExpireOn()));
			}
			if (Utilities.notBlank(dto.getToken())) {
				entityToSave.setToken(dto.getToken());
			}
			if (Utilities.notBlank(dto.getDeletedAt())) {
				entityToSave.setDeletedAt(dateFormat.parse(dto.getDeletedAt()));
			}
			if (dto.getCreatedBy() != null && dto.getCreatedBy() > 0) {
				entityToSave.setCreatedBy(dto.getCreatedBy());
			}
			if (dto.getUpdatedBy() != null && dto.getUpdatedBy() > 0) {
				entityToSave.setUpdatedBy(dto.getUpdatedBy());
			}
			if (Utilities.notBlank(dto.getCommentaire())) {
				entityToSave.setCommentaire(dto.getCommentaire());
			}
			if (dto.getStatusId() != null && dto.getStatusId() > 0) {
				entityToSave.setStatusId(dto.getStatusId());
			}
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			entityToSave.setUpdatedBy(request.getUser());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Otp> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = otpRepository.saveAll((Iterable<Otp>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("otp", locale));
				response.setHasError(true);
				return response;
			}
			List<OtpDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OtpTransformer.toLiteDtos(itemsSaved) : OtpTransformer.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		// System.out.println("----end update Otp-----");
		return response;
	}

	/**
	 * delete Otp by using OtpDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OtpDto> delete(Request<OtpDto> request, Locale locale)  {
		// System.out.println("----begin delete Otp-----");

		Response<OtpDto> response = new Response<OtpDto>();
		List<Otp>        items    = new ArrayList<Otp>();
			
		for (OtpDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la otp existe
			Otp existingEntity = null;

			existingEntity = otpRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("otp -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------



			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setIsDeleted(true);
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			otpRepository.saveAll((Iterable<Otp>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Otp-----");
		return response;
	}

	/**
	 * get Otp by using OtpDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OtpDto> getByCriteria(Request<OtpDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Otp-----");

		Response<OtpDto> response = new Response<OtpDto>();
		List<Otp> items 			 = otpRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<OtpDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OtpTransformer.toLiteDtos(items) : OtpTransformer.toDtos(items);

			final int size = items.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setCount(otpRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("otp", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Otp-----");
		return response;
	}

	/**
	 * get full OtpDto by using Otp as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private OtpDto getFullInfos(OtpDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
		// put code here

		if (Utilities.isTrue(isSimpleLoading)) {
			return dto;
		}
		if (size > 1) {
			return dto;
		}

		return dto;
	}
}
