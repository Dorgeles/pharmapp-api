                                                    												
/*
 * Java business for entity table ordonnance 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Ordonnance;
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
BUSINESS for table "ordonnance"
 * 
 * @author Geo
 *
 */

@Component
public class OrdonnanceBusiness implements IBasicBusiness<Request<OrdonnanceDto>, Response<OrdonnanceDto>> {

	private Response<OrdonnanceDto> response;
	@Autowired
	private OrdonnanceRepository ordonnanceRepository;
	@Autowired
	private MinioExternalService minioExternalService;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private OrdonnanceMedicamentRepository ordonnanceMedicamentRepository;
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

	public OrdonnanceBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Ordonnance by using OrdonnanceDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceDto> create(Request<OrdonnanceDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Ordonnance-----");

		Response<OrdonnanceDto> response = new Response<OrdonnanceDto>();
		List<Ordonnance>        items    = new ArrayList<Ordonnance>();
			
		for (OrdonnanceDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("dateEmission", dto.getDateEmission());
			fieldsToVerify.put("userId", dto.getUserId());
			fieldsToVerify.put("images", dto.getImages());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if ordonnance to insert do not exist
			Ordonnance existingEntity = null;

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
				Ordonnance entityToSave = null;
			entityToSave = OrdonnanceTransformer.toEntity(dto, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Ordonnance> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = ordonnanceRepository.saveAll((Iterable<Ordonnance>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("ordonnance", locale));
				response.setHasError(true);
				return response;
			}
			List<OrdonnanceDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdonnanceTransformer.toLiteDtos(itemsSaved) : OrdonnanceTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Ordonnance-----");
		return response;
	}

	/**
	 * update Ordonnance by using OrdonnanceDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceDto> update(Request<OrdonnanceDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Ordonnance-----");

		Response<OrdonnanceDto> response = new Response<OrdonnanceDto>();
		List<Ordonnance>        items    = new ArrayList<Ordonnance>();
			
		for (OrdonnanceDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la ordonnance existe
			Ordonnance entityToSave = null;
			entityToSave = ordonnanceRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("ordonnance id -> " + dto.getId(), locale));
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
			if (Utilities.notBlank(dto.getDateEmission())) {
				entityToSave.setDateEmission(dto.getDateEmission());
			}
			if (Utilities.notBlank(dto.getImageUrl())) {
				entityToSave.setImageUrl(dto.getImageUrl());
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
			List<Ordonnance> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = ordonnanceRepository.saveAll((Iterable<Ordonnance>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("ordonnance", locale));
				response.setHasError(true);
				return response;
			}
			List<OrdonnanceDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdonnanceTransformer.toLiteDtos(itemsSaved) : OrdonnanceTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Ordonnance-----");
		return response;
	}

	/**
	 * delete Ordonnance by using OrdonnanceDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceDto> delete(Request<OrdonnanceDto> request, Locale locale)  {
		// System.out.println("----begin delete Ordonnance-----");

		Response<OrdonnanceDto> response = new Response<OrdonnanceDto>();
		List<Ordonnance>        items    = new ArrayList<Ordonnance>();
			
		for (OrdonnanceDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la ordonnance existe
			Ordonnance existingEntity = null;

			existingEntity = ordonnanceRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("ordonnance -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// commande
			List<Commande> listOfCommande = commandeRepository.findByOrdonnanceId(existingEntity.getId(), false);
			if (listOfCommande != null && !listOfCommande.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCommande.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// ordonnanceMedicament
			List<OrdonnanceMedicament> listOfOrdonnanceMedicament = ordonnanceMedicamentRepository.findByOrdonnanceId(existingEntity.getId(), false);
			if (listOfOrdonnanceMedicament != null && !listOfOrdonnanceMedicament.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfOrdonnanceMedicament.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setIsDeleted(true);
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			ordonnanceRepository.saveAll((Iterable<Ordonnance>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Ordonnance-----");
		return response;
	}

	/**
	 * get Ordonnance by using OrdonnanceDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceDto> getByCriteria(Request<OrdonnanceDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Ordonnance-----");

		Response<OrdonnanceDto> response = new Response<OrdonnanceDto>();
		List<Ordonnance> items 			 = ordonnanceRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<OrdonnanceDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdonnanceTransformer.toLiteDtos(items) : OrdonnanceTransformer.toDtos(items);

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
			response.setCount(ordonnanceRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("ordonnance", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Ordonnance-----");
		return response;
	}

	/**
	 * get full OrdonnanceDto by using Ordonnance as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private OrdonnanceDto getFullInfos(OrdonnanceDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
