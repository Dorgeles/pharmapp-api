                                                											
/*
 * Java business for entity table user_roles 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Roles;
import com.wdyapplications.pharmapp.dao.entity.UserRoles;
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
BUSINESS for table "user_roles"
 * 
 * @author Geo
 *
 */

@Component
public class UserRolesBusiness implements IBasicBusiness<Request<UserRolesDto>, Response<UserRolesDto>> {

	private Response<UserRolesDto> response;
	@Autowired
	private UserRolesRepository userRolesRepository;
	@Autowired
	private RolesRepository rolesRepository;
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

	public UserRolesBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create UserRoles by using UserRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRolesDto> create(Request<UserRolesDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create UserRoles-----");

		Response<UserRolesDto> response = new Response<UserRolesDto>();
		List<UserRoles>        items    = new ArrayList<UserRoles>();
			
		for (UserRolesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("userId", dto.getUserId());
			fieldsToVerify.put("roleId", dto.getRoleId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if userRoles to insert do not exist
			UserRoles existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("userRoles id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if roles exist
			Roles existingRoles = null;
			if (dto.getRoleId() != null && dto.getRoleId() > 0){
				existingRoles = rolesRepository.findOne(dto.getRoleId(), false);
				if (existingRoles == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("roles roleId -> " + dto.getRoleId(), locale));
					response.setHasError(true);
					return response;
				}
			}
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
				UserRoles entityToSave = null;
			entityToSave = UserRolesTransformer.toEntity(dto, existingRoles, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UserRoles> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = userRolesRepository.saveAll((Iterable<UserRoles>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userRoles", locale));
				response.setHasError(true);
				return response;
			}
			List<UserRolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserRolesTransformer.toLiteDtos(itemsSaved) : UserRolesTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create UserRoles-----");
		return response;
	}

	/**
	 * update UserRoles by using UserRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRolesDto> update(Request<UserRolesDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update UserRoles-----");

		Response<UserRolesDto> response = new Response<UserRolesDto>();
		List<UserRoles>        items    = new ArrayList<UserRoles>();
			
		for (UserRolesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userRoles existe
			UserRoles entityToSave = null;
			entityToSave = userRolesRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userRoles id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if roles exist
			if (dto.getRoleId() != null && dto.getRoleId() > 0){
				Roles existingRoles = rolesRepository.findOne(dto.getRoleId(), false);
				if (existingRoles == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("roles roleId -> " + dto.getRoleId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setRoles(existingRoles);
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
			List<UserRoles> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = userRolesRepository.saveAll((Iterable<UserRoles>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userRoles", locale));
				response.setHasError(true);
				return response;
			}
			List<UserRolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserRolesTransformer.toLiteDtos(itemsSaved) : UserRolesTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update UserRoles-----");
		return response;
	}

	/**
	 * delete UserRoles by using UserRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRolesDto> delete(Request<UserRolesDto> request, Locale locale)  {
		// System.out.println("----begin delete UserRoles-----");

		Response<UserRolesDto> response = new Response<UserRolesDto>();
		List<UserRoles>        items    = new ArrayList<UserRoles>();
			
		for (UserRolesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userRoles existe
			UserRoles existingEntity = null;

			existingEntity = userRolesRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userRoles -> " + dto.getId(), locale));
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
			userRolesRepository.saveAll((Iterable<UserRoles>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete UserRoles-----");
		return response;
	}

	/**
	 * get UserRoles by using UserRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRolesDto> getByCriteria(Request<UserRolesDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get UserRoles-----");

		Response<UserRolesDto> response = new Response<UserRolesDto>();
		List<UserRoles> items 			 = userRolesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UserRolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserRolesTransformer.toLiteDtos(items) : UserRolesTransformer.toDtos(items);

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
			response.setCount(userRolesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("userRoles", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get UserRoles-----");
		return response;
	}

	/**
	 * get full UserRolesDto by using UserRoles as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UserRolesDto getFullInfos(UserRolesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
