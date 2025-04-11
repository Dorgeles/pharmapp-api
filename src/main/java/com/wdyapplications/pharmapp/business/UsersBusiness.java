                                                    												
/*
 * Java business for entity table users 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;

import com.wdyapplications.pharmapp.dao.entity.*;
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
import com.wdyapplications.pharmapp.utils.security.PasswordUtils;
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
BUSINESS for table "users"
 * 
 * @author Geo
 *
 */

@Component
public class UsersBusiness implements IBasicBusiness<Request<UsersDto>, Response<UsersDto>> {

	private Response<UsersDto> response;
	@Autowired
	private PasswordUtils passwordUtils;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private AssurancesRepository assurancesRepository;
	@Autowired
	private OtpBusiness otpBusiness;
	@Autowired
	private OtpRepository otpRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UserRolesRepository userRolesRepository;
	@Autowired
	private UserPreferencesRepository userPreferencesRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;
	@Autowired
	private UserActivityRepository userActivityRepository;
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

	public UsersBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> create(Request<UsersDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users>        items    = new ArrayList<Users>();
			
		for (UsersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("username", dto.getUsername());
			fieldsToVerify.put("password", dto.getPassword());
			fieldsToVerify.put("email", dto.getEmail());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users to insert do not exist
			Users existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("users id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique email in db
			existingEntity = usersRepository.findByEmail(dto.getEmail(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("cet email -> " + dto.getEmail(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" email ", locale));
				response.setHasError(true);
				return response;
			}
			// verif unique username in db
			List<Users> usersByUsernames = usersRepository.findByUsername(dto.getUsername(), false);
			if (Utilities.isNotEmpty(usersByUsernames)) {
				response.setStatus(functionalError.DATA_EXIST("cet username -> " + dto.getUsername(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getUsername().equalsIgnoreCase(dto.getUsername()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" username ", locale));
				response.setHasError(true);
				return response;
			}
			// hashed the password
			dto.setPassword(passwordUtils.hashPassword(dto.getPassword()));

			Users entityToSave = null;
			entityToSave = UsersTransformer.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Users> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = usersRepository.saveAll((Iterable<Users>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("users", locale));
				response.setHasError(true);
				return response;
			}
			List<UsersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UsersTransformer.toLiteDtos(itemsSaved) : UsersTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Users-----");
		return response;
	}


	public Response<UsersDto> initRessetPassword(Request<UsersDto> request, Locale locale)  throws ParseException {
		Response<UsersDto> response = new Response<UsersDto>();
		try {
			UsersDto dto                 = request.getData();
			Users    users               = null;
			if (dto != null) {
				HashMap<String, Object> fieldsToVerify = new HashMap<>();
				fieldsToVerify.put("username", dto.getUsername());
				if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
					response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
					response.setHasError(true);
					return response;
				}
				Users userNormal = null;
				List<Users>	findUsers = usersRepository.findExistingUsersFromSearch(dto.getUsername(),  false);
				if (Utilities.isEmpty(findUsers)) {
					response.setStatus(functionalError.DATA_NOT_EXIST(
							"Ce username n'appartient pas a aucun utilisateur", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				if (findUsers.size() > 1) {
					response.setStatus(functionalError.DATA_DUPLICATE("username", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				userNormal = findUsers.get(0);
				// creation de l'otp
				OtpDto otpDto = new OtpDto();
				otpDto.setIdentifier(userNormal.getUsername());
				otpDto.setOrigineElementId(1);
				otpDto.setCodeOtp(String.valueOf((int) (Math.random() * 9000) + 1000));
				Request<OtpDto> otpDtoRequest = new Request<OtpDto>();
				otpDtoRequest.setUser(userNormal.getId());
				otpDtoRequest.setDatas(Arrays.asList(otpDto));
				Response<OtpDto> otpDtoResponse = otpBusiness.create(otpDtoRequest, locale);
				if (otpDtoResponse.isHasError()) {
					response.setStatus(functionalError.SAVE_FAIL("otp", locale));
					response.setHasError(true);
					return response;
				}
				// fin de la creation de l'otp
				response.setStatus(functionalError.SUCCESS("OTP envoyé",locale));
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


	public Response<UsersDto> resetPassword(Request<UsersDto> request, Locale locale)  throws ParseException {
		Response<UsersDto> response = new Response<UsersDto>();
		try {
			UsersDto dto                 = request.getData();
			Users    users               = null;
			if (dto != null) {
				HashMap<String, Object> fieldsToVerify = new HashMap<>();
				fieldsToVerify.put("password", dto.getPassword());
				fieldsToVerify.put("token", dto.getToken());
				if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
					response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
					response.setHasError(true);
					return response;
				}
				Users userNormal = null;
				List<Otp> acceptedOtp = otpRepository.findByToken(dto.getToken(),  false);
				if (Utilities.isEmpty(acceptedOtp)) {
					response.setStatus(functionalError.DATA_NOT_EXIST(
							"Action refusée : Otp n'existe pas", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				userNormal = usersRepository.findOne(acceptedOtp.get(0).getCreatedBy(), false);
				if (userNormal == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST(
							"Action refusée : Utilisateur n'existe pas", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}

				// hashed the password
				dto.setPassword(passwordUtils.hashPassword(dto.getPassword()));
				userNormal.setPassword(dto.getPassword());
				usersRepository.save(userNormal);
				response.setStatus(functionalError.SUCCESS("Mot de passe modifié",locale));
				response.setHasError(false);
			} else {
			Status status = new Status();
			status.setCode("400");
			status.setMessage("Bad Request");
			response.setStatus(status);
			response.setHasError(true);
		}
		}
		catch (PermissionDeniedDataAccessException e) {
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

	public Response<UsersDto> login(Request<UsersDto> request, Locale locale)  throws ParseException {
		Response<UsersDto> response = new Response<UsersDto>();
		try {
			UsersDto dto                 = request.getData();
			Integer  existingSessionTime = null;
			Users    users               = null;
			if (dto != null) {
				HashMap<String, Object> fieldsToVerify = new HashMap<>();
				fieldsToVerify.put("username", dto.getUsername());
				fieldsToVerify.put("password", dto.getPassword());
				if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
					response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
					response.setHasError(true);
					return response;
				}
				List<UsersDto> itemsSaved = new ArrayList<UsersDto>();
				Date           targetTime = Calendar.getInstance().getTime();
				String         newDate    = dateFormat.format(targetTime);
				Date           dateNow    = dateFormat.parse(newDate);
				System.out.println("----begin connexion Users-----");
				Users userNormal = null;

				List<Users>	findUsers = usersRepository.findByUsername(dto.getUsername(), false);
				if (Utilities.isEmpty(findUsers)) {
					response.setStatus(functionalError.DATA_NOT_EXIST(
							"Ce username n'appartient pas a aucun utilisateur", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				if (findUsers.size() > 1) {
					response.setStatus(functionalError.DATA_DUPLICATE("username", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				userNormal = findUsers.get(0);
				if (userNormal.getStatusId() == GlobaleEnum.RESTRICTED) {
					Status status = new Status();
					status.setMessage("Le compte est restreint, veuillez contacter l'administrateur");
					status.setCode("10");
					response.setStatus(status);
					response.setHasError(Boolean.TRUE);
					return response;
				}
				boolean isPasswordMatch = passwordUtils.matches(dto.getPassword(), userNormal.getPassword());
				if (!isPasswordMatch) {
					response.setStatus(functionalError.LOGIN_FAIL(locale));
					response.setHasError(true);
					return response;
				}
				UsersDto usersDto = getFullInfos(UsersTransformer.toDto(userNormal), 1, false,
						locale
				);
				users = userNormal;
				users.setUpdatedAt(Utilities.getCurrentDate());
				usersRepository.save(users);
				response.setItems(Arrays.asList(usersDto));
				response.setStatus(functionalError.SUCCESS("Utilisateur connecté",locale));
				response.setHasError(false);
				System.out.println("----end connexion Users-----");
			}
		} catch (PermissionDeniedDataAccessException e)
		{
			exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
		} catch (DataAccessResourceFailureException e)
		{
			exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
		} catch (DataAccessException e)
		{
			exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
		} catch (RuntimeException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{

		}
		// Definir les parametres obligatoires

		return response;
	}
	public Response<UsersDto> changePassword(Request<UsersDto> request, Locale locale)  throws ParseException {
		Response<UsersDto> response = new Response<UsersDto>();
		try {
			UsersDto dto                 = request.getData();
			Integer  existingSessionTime = null;
			Users    users               = null;
			if (dto != null) {
				HashMap<String, Object> fieldsToVerify = new HashMap<>();
				fieldsToVerify.put("token", dto.getToken()); //
				fieldsToVerify.put("password", dto.getPassword());
				if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
					response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
					response.setHasError(true);
					return response;
				}
				List<Otp> validOtps = null;
				validOtps = otpRepository.findByToken(dto.getToken(), false);
				if (Utilities.isEmpty(validOtps)) {
					Status status = new Status();
					status.setCode("444");
					status.setMessage("Action réfusée: vous n'avez pas de demande de changement de mot de passe valide");
					response.setStatus(status);
					response.setHasError(Boolean.TRUE);
					return response;
				}
				for (Otp otp : validOtps) {
					if (otp.getIsExpired() == Boolean.FALSE) {
						Status status = new Status();
						status.setCode("444");
						status.setMessage("Action réfusée: vous n'avez pas de demande de changement de mot de passe valide");
						response.setStatus(status);
						response.setHasError(Boolean.TRUE);
						return response;
					}
				}
				users = usersRepository.findOne(validOtps.get(0).getCreatedBy(), false);
				if (users == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST(
							"Action refusée : Utilisateur n'existe pas", locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				//String dec = passwordUtils.decryptPassword(users.getPassword());
				boolean isPasswordMatch = passwordUtils.matches(dto.getPassword(), users.getPassword());
				if (isPasswordMatch) {
					response.setStatus(functionalError.AUTH_FAIL("Vos mots de passe sont identique" , locale));
					response.setHasError(Boolean.TRUE);
					return response;
				}
				String newPassword = passwordUtils.hashPassword(dto.getPassword());
				// hashed the password
				users.setPassword(newPassword);
				usersRepository.save(users);
				response.setStatus(functionalError.SUCCESS("Mot de passe modifié",locale));
				response.setHasError(false);
				System.out.println("----end connexion Users-----");
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
		// Definir les parametres obligatoires

		return response;
	}

	/**
	 * update Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> update(Request<UsersDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users>        items    = new ArrayList<Users>();
			
		for (UsersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la users existe
			Users entityToSave = null;
			entityToSave = usersRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("users id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getUsername())) {
				entityToSave.setUsername(dto.getUsername());
			}
			if (Utilities.notBlank(dto.getPassword())) {
				entityToSave.setPassword(dto.getPassword());
			}
			if (Utilities.notBlank(dto.getEmail())) {
				entityToSave.setEmail(dto.getEmail());
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
			List<Users> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = usersRepository.saveAll((Iterable<Users>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("users", locale));
				response.setHasError(true);
				return response;
			}
			List<UsersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UsersTransformer.toLiteDtos(itemsSaved) : UsersTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Users-----");
		return response;
	}

	/**
	 * delete Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> delete(Request<UsersDto> request, Locale locale)  {
		// System.out.println("----begin delete Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users>        items    = new ArrayList<Users>();
			
		for (UsersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la users existe
			Users existingEntity = null;

			existingEntity = usersRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("users -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// userRoles
			List<UserRoles> listOfUserRoles = userRolesRepository.findByUserId(existingEntity.getId(), false);
			if (listOfUserRoles != null && !listOfUserRoles.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserRoles.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// userPreferences
			List<UserPreferences> listOfUserPreferences = userPreferencesRepository.findByUserId(existingEntity.getId(), false);
			if (listOfUserPreferences != null && !listOfUserPreferences.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserPreferences.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// userProfile
			List<UserProfile> listOfUserProfile = userProfileRepository.findByUserId(existingEntity.getId(), false);
			if (listOfUserProfile != null && !listOfUserProfile.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserProfile.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// userActivity
			List<UserActivity> listOfUserActivity = userActivityRepository.findByUserId(existingEntity.getId(), false);
			if (listOfUserActivity != null && !listOfUserActivity.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserActivity.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setIsDeleted(true);
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			usersRepository.saveAll((Iterable<Users>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Users-----");
		return response;
	}

	/**
	 * get Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> getByCriteria(Request<UsersDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users> items 			 = usersRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UsersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UsersTransformer.toLiteDtos(items) : UsersTransformer.toDtos(items);

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
			response.setCount(usersRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("users", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Users-----");
		return response;
	}

	/**
	 * get full UsersDto by using Users as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public UsersDto getFullInfos(UsersDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
		// put code here
		// removing the password from the response
		dto.setPassword(null);
		if (Utilities.isTrue(isSimpleLoading)) {
			return dto;
		}
		if (size > 1) {
			return dto;
		}
		// reccuperation des roles
		List<UserRoles> listOfUserRoles = userRolesRepository.findByUserId(dto.getId(), false);
		if (listOfUserRoles != null && !listOfUserRoles.isEmpty()) {
			List<Roles> listOfRoles = new ArrayList<Roles>();
			for (UserRoles userRole : listOfUserRoles) {
				listOfRoles.add(userRole.getRoles());
			}
			dto.setDataRoles(RolesTransformer.toLiteDtos(listOfRoles));
		}
		// reccuperation des profils
		List<UserProfile> listOfUserProfile = userProfileRepository.findByUserId(dto.getId(), false);
		if (Utilities.isNotEmpty(listOfUserProfile)) {
			List<UserProfileDto> listOfUserProfileDto = UserProfileTransformer.toLiteDtos(listOfUserProfile);
			dto.setDataProfiles(listOfUserProfileDto);
		}
		// reccupération des adresses de l'utilisateur
		List<Adresse> listOfAdresse = adresseRepository.findByUserId(dto.getId(), false);
		if (Utilities.isNotEmpty(listOfAdresse)) {
			List<AdresseDto> listOfAdresseDto = AdresseTransformer.toLiteDtos(listOfAdresse);
			dto.setDataAdresses(listOfAdresseDto);
		}
		// reccupération des assurances de l'utilisateur
		List<Assurances> listOfAssurances = assurancesRepository.findByUserId(dto.getId(), false);
		if (Utilities.isNotEmpty(listOfAssurances)) {
			List<AssurancesDto> listOfAssurancesDto = AssurancesTransformer.toDtos(listOfAssurances);
			dto.setDataAssurances(listOfAssurancesDto);
		}

		return dto;
	}
}
