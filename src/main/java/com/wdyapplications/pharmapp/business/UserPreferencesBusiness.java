                                                    												
/*
 * Java business for entity table user_preferences 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.UserPreferences;
import com.wdyapplications.pharmapp.dao.entity.Users;
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
BUSINESS for table "user_preferences"
 * 
 * @author Geo
 *
 */

@Component
public class UserPreferencesBusiness implements IBasicBusiness<Request<UserPreferencesDto>, Response<UserPreferencesDto>> {

	private Response<UserPreferencesDto> response;
	@Autowired
	private UserPreferencesRepository userPreferencesRepository;
	@Autowired
	private UsersRepository usersRepository;
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

	public UserPreferencesBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create UserPreferences by using UserPreferencesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserPreferencesDto> create(Request<UserPreferencesDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create UserPreferences-----");

		Response<UserPreferencesDto> response = new Response<UserPreferencesDto>();
		List<UserPreferences>        items    = new ArrayList<UserPreferences>();
			
		for (UserPreferencesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("preferenceKey", dto.getPreferenceKey());
			fieldsToVerify.put("preferenceValue", dto.getPreferenceValue());
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if userPreferences to insert do not exist
			UserPreferences existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("userPreferences id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if users exist
			Users existingUsers = null;
			if (dto.getUserId() != null && dto.getUserId() > 0){
				existingUsers = usersRepository.findOne(dto.getUserId(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users userId -> " + dto.getUserId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				UserPreferences entityToSave = null;
			entityToSave = UserPreferencesTransformer.toEntity(dto, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UserPreferences> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = userPreferencesRepository.saveAll((Iterable<UserPreferences>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userPreferences", locale));
				response.setHasError(true);
				return response;
			}
			List<UserPreferencesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserPreferencesTransformer.toLiteDtos(itemsSaved) : UserPreferencesTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create UserPreferences-----");
		return response;
	}

	/**
	 * update UserPreferences by using UserPreferencesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserPreferencesDto> update(Request<UserPreferencesDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update UserPreferences-----");

		Response<UserPreferencesDto> response = new Response<UserPreferencesDto>();
		List<UserPreferences>        items    = new ArrayList<UserPreferences>();
			
		for (UserPreferencesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userPreferences existe
			UserPreferences entityToSave = null;
			entityToSave = userPreferencesRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userPreferences id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users exist
			if (dto.getUserId() != null && dto.getUserId() > 0){
				Users existingUsers = usersRepository.findOne(dto.getUserId(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users userId -> " + dto.getUserId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUsers(existingUsers);
			}
			if (Utilities.notBlank(dto.getPreferenceKey())) {
				entityToSave.setPreferenceKey(dto.getPreferenceKey());
			}
			if (Utilities.notBlank(dto.getPreferenceValue())) {
				entityToSave.setPreferenceValue(dto.getPreferenceValue());
			}
			if (dto.getCreatedBy() != null && dto.getCreatedBy() > 0) {
				entityToSave.setCreatedBy(dto.getCreatedBy());
			}
			if (Utilities.notBlank(dto.getDeletedAt())) {
				entityToSave.setDeletedAt(dateFormat.parse(dto.getDeletedAt()));
			}
			if (dto.getStatusId() != null && dto.getStatusId() > 0) {
				entityToSave.setStatusId(dto.getStatusId());
			}
			if (dto.getUpdatedBy() != null && dto.getUpdatedBy() > 0) {
				entityToSave.setUpdatedBy(dto.getUpdatedBy());
			}
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			entityToSave.setUpdatedBy(request.getUser());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UserPreferences> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = userPreferencesRepository.saveAll((Iterable<UserPreferences>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userPreferences", locale));
				response.setHasError(true);
				return response;
			}
			List<UserPreferencesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserPreferencesTransformer.toLiteDtos(itemsSaved) : UserPreferencesTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update UserPreferences-----");
		return response;
	}

	/**
	 * delete UserPreferences by using UserPreferencesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserPreferencesDto> delete(Request<UserPreferencesDto> request, Locale locale)  {
		// System.out.println("----begin delete UserPreferences-----");

		Response<UserPreferencesDto> response = new Response<UserPreferencesDto>();
		List<UserPreferences>        items    = new ArrayList<UserPreferences>();
			
		for (UserPreferencesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userPreferences existe
			UserPreferences existingEntity = null;

			existingEntity = userPreferencesRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userPreferences -> " + dto.getId(), locale));
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
			userPreferencesRepository.saveAll((Iterable<UserPreferences>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete UserPreferences-----");
		return response;
	}

	/**
	 * get UserPreferences by using UserPreferencesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserPreferencesDto> getByCriteria(Request<UserPreferencesDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get UserPreferences-----");

		Response<UserPreferencesDto> response = new Response<UserPreferencesDto>();
		List<UserPreferences> items 			 = userPreferencesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UserPreferencesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserPreferencesTransformer.toLiteDtos(items) : UserPreferencesTransformer.toDtos(items);

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
			response.setCount(userPreferencesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("userPreferences", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get UserPreferences-----");
		return response;
	}

	/**
	 * get full UserPreferencesDto by using UserPreferences as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public UserPreferencesDto getFullInfos(UserPreferencesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
