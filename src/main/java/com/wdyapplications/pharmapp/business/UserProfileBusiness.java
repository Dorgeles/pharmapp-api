                                                        													
/*
 * Java business for entity table user_profile 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;

import com.wdyapplications.pharmapp.dao.entity.UserProfile;
import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.dao.repository.*;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.IBasicBusiness;
import com.wdyapplications.pharmapp.utils.contract.Request;
import com.wdyapplications.pharmapp.utils.contract.Response;
import com.wdyapplications.pharmapp.utils.dto.*;
import com.wdyapplications.pharmapp.utils.dto.transformer.*;
import com.wdyapplications.pharmapp.utils.enums.*;
import com.wdyapplications.pharmapp.utils.okhttp.MinioExternalService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
BUSINESS for table "user_profile"
 * 
 * @author Geo
 *
 */


@Component
public class UserProfileBusiness implements IBasicBusiness<Request<UserProfileDto>, Response<UserProfileDto>> {

	private Response<UserProfileDto> response;
	@Autowired
	private UserProfileRepository userProfileRepository;
    @Autowired
    private UserRolesBusiness userRolesBusiness;
	@Autowired
	private UsersBusiness usersBusiness;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private MinioExternalService minioExternalService;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;

	public UserProfileBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create UserProfile by using UserProfileDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserProfileDto> create(Request<UserProfileDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create UserProfile-----");

		Response<UserProfileDto> response = new Response<UserProfileDto>();
		List<UserProfile>        items    = new ArrayList<UserProfile>();
			
		for (UserProfileDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("firstname", dto.getFirstname());
			fieldsToVerify.put("lastname", dto.getLastname());
			fieldsToVerify.put("images", dto.getImages());
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if userProfile to insert do not exist
			UserProfile existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("userProfile id -> " + dto.getId(), locale));
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

			if (Utilities.isNotEmpty(dto.getImages())){
				StringBuilder listUrl = new StringBuilder();
				for (ImageDto image : dto.getImages()) {
					try {
						image.setFilename(UUID.randomUUID().toString()  +".png");
						String imageUrl = 	minioExternalService.saveImage(image);
						listUrl.append(imageUrl).append(";");
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				dto.setProfilePicture(listUrl.toString());
			}
				UserProfile entityToSave = null;
			entityToSave = UserProfileTransformer.toEntity(dto, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UserProfile> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = userProfileRepository.saveAll((Iterable<UserProfile>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userProfile", locale));
				response.setHasError(true);
				return response;
			}
			List<UserProfileDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserProfileTransformer.toLiteDtos(itemsSaved) : UserProfileTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create UserProfile-----");
		return response;
	}


	public Response<UserProfileDto> createUser(Request<UserProfileDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create UserProfile-----");

		Response<UserProfileDto> response = new Response<UserProfileDto>();
		List<UserProfile>        items    = new ArrayList<UserProfile>();
		try {
			for (UserProfileDto dto : request.getDatas()) {
				Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
				fieldsToVerify.put("firstname", dto.getFirstname());
				fieldsToVerify.put("lastname", dto.getLastname());
				fieldsToVerify.put("images", dto.getImages());
				fieldsToVerify.put("userInfo", dto.getUsersDto());
				if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
					response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
					response.setHasError(true);
					return response;
				}
				// creation du user
				Request<UsersDto> requestUser = new Request<UsersDto>();
				requestUser.setDatas(Arrays.asList(dto.getUsersDto()));
				Response<UsersDto> responseUser = usersBusiness.create(requestUser, locale);
				if (responseUser.isHasError()) {
					response.setStatus(responseUser.getStatus());
					response.setHasError(true);
					return response;
				}
				dto.setUsersDto(responseUser.getItems().get(0));
				// création du profile
				UserProfileDto newDto = new UserProfileDto();
				newDto.setUserId(responseUser.getItems().get(0).getId());
				newDto.setFirstname(dto.getFirstname());
				newDto.setLastname(dto.getLastname());
				newDto.setProfilePicture(dto.getProfilePicture());
				newDto.setImages(dto.getImages());

				Request<UserProfileDto> requestUserProfile = new Request<UserProfileDto>();
				requestUserProfile.setDatas(Arrays.asList(newDto));
				Response<UserProfileDto> responseUserProfile = create(requestUserProfile, locale);
				if (responseUserProfile.isHasError()) {
					response.setStatus(responseUserProfile.getStatus());
					response.setHasError(true);
					return response;
				}
                // attribution des roles dans le cas ou ils existent dans la requette
                if (Utilities.isNotEmpty(dto.getDatasRoles())) {
                    List<UserRolesDto> listAttrib = new ArrayList<>();
                    for (RolesDto role : dto.getDatasRoles()) {
                        UserRolesDto userRole = new UserRolesDto();
                        userRole.setUserId(responseUser.getItems().get(0).getId());
                        userRole.setRoleId(role.getId());
                        listAttrib.add(userRole);
                    }
                    Request<UserRolesDto> requestUserRoles = new Request<>();
                    requestUserRoles.setUser(dto.getUserId());
                    requestUserRoles.setDatas(listAttrib);
                    Response<UserRolesDto> responseUserRoles = userRolesBusiness.create(requestUserRoles, Locale.FRENCH);
                    if (responseUserRoles.isHasError()){
                        response.setStatus(responseUserProfile.getStatus());
                        response.setHasError(true);
                        return response;
                    }
                }
				response.setItems(responseUserProfile.getItems());
				response.setHasError(false);
			}
		} catch (PermissionDeniedDataAccessException e) {
			exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
		} catch (DataAccessResourceFailureException e) {
			exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
		} catch (DataAccessException e) {
			exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return response;
	}

	/**
	 * update UserProfile by using UserProfileDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserProfileDto> update(Request<UserProfileDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update UserProfile-----");

		Response<UserProfileDto> response = new Response<UserProfileDto>();
		List<UserProfile>        items    = new ArrayList<UserProfile>();
			
		for (UserProfileDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userProfile existe
			UserProfile entityToSave = null;
			entityToSave = userProfileRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userProfile id -> " + dto.getId(), locale));
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
			if (Utilities.notBlank(dto.getFirstname())) {
				entityToSave.setFirstname(dto.getFirstname());
			}
			if (Utilities.notBlank(dto.getContact())) {
				entityToSave.setFirstname(dto.getContact());
			}
			if (Utilities.isNotEmpty(dto.getImages())){
				StringBuilder listUrl = new StringBuilder();
				for (ImageDto image : dto.getImages()) {
					try {
						image.setFilename(UUID.randomUUID().toString()  +".png");
						String imageUrl = 	minioExternalService.saveImage(image);
						listUrl.append(imageUrl).append(";");
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				dto.setProfilePicture(listUrl.toString());
			}
			if (Utilities.notBlank(dto.getLastname())) {
				entityToSave.setLastname(dto.getLastname());
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
			List<UserProfile> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = userProfileRepository.saveAll((Iterable<UserProfile>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userProfile", locale));
				response.setHasError(true);
				return response;
			}
			List<UserProfileDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserProfileTransformer.toLiteDtos(itemsSaved) : UserProfileTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update UserProfile-----");
		return response;
	}

	/**
	 * delete UserProfile by using UserProfileDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserProfileDto> delete(Request<UserProfileDto> request, Locale locale)  {
		// System.out.println("----begin delete UserProfile-----");

		Response<UserProfileDto> response = new Response<UserProfileDto>();
		List<UserProfile>        items    = new ArrayList<UserProfile>();
			
		for (UserProfileDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userProfile existe
			UserProfile existingEntity = null;

			existingEntity = userProfileRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userProfile -> " + dto.getId(), locale));
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
			userProfileRepository.saveAll((Iterable<UserProfile>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete UserProfile-----");
		return response;
	}

	/**
	 * get UserProfile by using UserProfileDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserProfileDto> getByCriteria(Request<UserProfileDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get UserProfile-----");

		Response<UserProfileDto> response = new Response<UserProfileDto>();
		List<UserProfile> items 			 = userProfileRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UserProfileDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserProfileTransformer.toLiteDtos(items) : UserProfileTransformer.toDtos(items);

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
			response.setCount(userProfileRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("userProfile", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get UserProfile-----");
		return response;
	}

	/**
	 * get full UserProfileDto by using UserProfile as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public UserProfileDto getFullInfos(UserProfileDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
