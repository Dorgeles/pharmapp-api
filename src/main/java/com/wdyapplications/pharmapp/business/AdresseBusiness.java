                                                            														
/*
 * Java business for entity table adresse 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Adresse;
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
BUSINESS for table "adresse"
 * 
 * @author Geo
 *
 */

@Component
public class AdresseBusiness implements IBasicBusiness<Request<AdresseDto>, Response<AdresseDto>> {

	private Response<AdresseDto> response;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CommandeRepository commandeRepository;
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

	public AdresseBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Adresse by using AdresseDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AdresseDto> create(Request<AdresseDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Adresse-----");

		Response<AdresseDto> response = new Response<AdresseDto>();
		List<Adresse>        items    = new ArrayList<Adresse>();
			
		for (AdresseDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("libelle", dto.getLibelle());
		//	fieldsToVerify.put("adresse", dto.getAdresse());
			fieldsToVerify.put("latitude", dto.getLatitude());
			fieldsToVerify.put("longitude", dto.getLongitude());
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if adresse to insert do not exist
			Adresse existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("adresse id -> " + dto.getId(), locale));
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
				Adresse entityToSave = null;
			entityToSave = AdresseTransformer.toEntity(dto, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Adresse> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = adresseRepository.saveAll((Iterable<Adresse>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("adresse", locale));
				response.setHasError(true);
				return response;
			}
			List<AdresseDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? AdresseTransformer.toLiteDtos(itemsSaved) : AdresseTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Adresse-----");
		return response;
	}

	/**
	 * update Adresse by using AdresseDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AdresseDto> update(Request<AdresseDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Adresse-----");

		Response<AdresseDto> response = new Response<AdresseDto>();
		List<Adresse>        items    = new ArrayList<Adresse>();
			
		for (AdresseDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la adresse existe
			Adresse entityToSave = null;
			entityToSave = adresseRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("adresse id -> " + dto.getId(), locale));
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
			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
			}
			if (Utilities.notBlank(dto.getAdresse())) {
				entityToSave.setAdresse(dto.getAdresse());
			}
			if (Utilities.notBlank(dto.getLatitude())) {
				entityToSave.setLatitude(dto.getLatitude());
			}
			if (Utilities.notBlank(dto.getLongitude())) {
				entityToSave.setLongitude(dto.getLongitude());
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
			List<Adresse> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = adresseRepository.saveAll((Iterable<Adresse>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("adresse", locale));
				response.setHasError(true);
				return response;
			}
			List<AdresseDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? AdresseTransformer.toLiteDtos(itemsSaved) : AdresseTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Adresse-----");
		return response;
	}

	/**
	 * delete Adresse by using AdresseDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AdresseDto> delete(Request<AdresseDto> request, Locale locale)  {
		// System.out.println("----begin delete Adresse-----");

		Response<AdresseDto> response = new Response<AdresseDto>();
		List<Adresse>        items    = new ArrayList<Adresse>();
			
		for (AdresseDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la adresse existe
			Adresse existingEntity = null;

			existingEntity = adresseRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("adresse -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// commande
			List<Commande> listOfCommande = commandeRepository.findByAdresseId(existingEntity.getId(), false);
			if (listOfCommande != null && !listOfCommande.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCommande.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setIsDeleted(true);
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			adresseRepository.saveAll((Iterable<Adresse>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Adresse-----");
		return response;
	}

	/**
	 * get Adresse by using AdresseDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AdresseDto> getByCriteria(Request<AdresseDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Adresse-----");

		Response<AdresseDto> response = new Response<AdresseDto>();
		List<Adresse> items 			 = adresseRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<AdresseDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? AdresseTransformer.toLiteDtos(items) : AdresseTransformer.toDtos(items);

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
			response.setCount(adresseRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("adresse", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Adresse-----");
		return response;
	}

	/**
	 * get full AdresseDto by using Adresse as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private AdresseDto getFullInfos(AdresseDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
