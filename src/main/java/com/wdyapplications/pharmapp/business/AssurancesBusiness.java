                                                        													
/*
 * Java business for entity table assurances 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Assurances;
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
import com.wdyapplications.pharmapp.utils.okhttp.MinioExternalService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
BUSINESS for table "assurances"
 * 
 * @author Geo
 *
 */

@Component
public class AssurancesBusiness implements IBasicBusiness<Request<AssurancesDto>, Response<AssurancesDto>> {

	private Response<AssurancesDto> response;
	@Autowired
	private AssurancesRepository assurancesRepository;
	@Autowired
	private MinioExternalService minioExternalService;
	@Autowired
	private CommandeRepository commandeRepository;
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

	public AssurancesBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Assurances by using AssurancesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AssurancesDto> create(Request<AssurancesDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Assurances-----");

		Response<AssurancesDto> response = new Response<AssurancesDto>();
		List<Assurances>        items    = new ArrayList<Assurances>();
			
		for (AssurancesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("images", dto.getImages());
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}
			// the use OCR help to provide Metadata

			// Verify if assurances to insert do not exist
			Assurances existingEntity = null;
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
				listUrl.deleteCharAt(listUrl.length() - 1);
				dto.setImageUrl(listUrl.toString());
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
				Assurances entityToSave = null;
			entityToSave = AssurancesTransformer.toEntity(dto, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Assurances> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = assurancesRepository.saveAll((Iterable<Assurances>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("assurances", locale));
				response.setHasError(true);
				return response;
			}
			List<AssurancesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? AssurancesTransformer.toLiteDtos(itemsSaved) : AssurancesTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Assurances-----");
		return response;
	}

	/**
	 * update Assurances by using AssurancesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AssurancesDto> update(Request<AssurancesDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Assurances-----");

		Response<AssurancesDto> response = new Response<AssurancesDto>();
		List<Assurances>        items    = new ArrayList<Assurances>();
			
		for (AssurancesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la assurances existe
			Assurances entityToSave = null;
			entityToSave = assurancesRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("assurances id -> " + dto.getId(), locale));
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
				listUrl.deleteCharAt(listUrl.length() - 1);
				dto.setImageUrl(listUrl.toString());
			}
			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
			}
			if (Utilities.notBlank(dto.getMetaData())) {
				entityToSave.setMetaData(dto.getMetaData());
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
			List<Assurances> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = assurancesRepository.saveAll((Iterable<Assurances>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("assurances", locale));
				response.setHasError(true);
				return response;
			}
			List<AssurancesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? AssurancesTransformer.toLiteDtos(itemsSaved) : AssurancesTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Assurances-----");
		return response;
	}

	/**
	 * delete Assurances by using AssurancesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AssurancesDto> delete(Request<AssurancesDto> request, Locale locale)  {
		// System.out.println("----begin delete Assurances-----");

		Response<AssurancesDto> response = new Response<AssurancesDto>();
		List<Assurances>        items    = new ArrayList<Assurances>();
			
		for (AssurancesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la assurances existe
			Assurances existingEntity = null;

			existingEntity = assurancesRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("assurances -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// commande
			List<Commande> listOfCommande = commandeRepository.findByAssuranceId(existingEntity.getId(), false);
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
			assurancesRepository.saveAll((Iterable<Assurances>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Assurances-----");
		return response;
	}

	/**
	 * get Assurances by using AssurancesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<AssurancesDto> getByCriteria(Request<AssurancesDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Assurances-----");

		Response<AssurancesDto> response = new Response<AssurancesDto>();
		List<Assurances> items 			 = assurancesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<AssurancesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? AssurancesTransformer.toLiteDtos(items) : AssurancesTransformer.toDtos(items);

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
			response.setCount(assurancesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("assurances", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Assurances-----");
		return response;
	}

	/**
	 * get full AssurancesDto by using Assurances as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private AssurancesDto getFullInfos(AssurancesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
