                                                                    																
/*
 * Java business for entity table pharmacie 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Pharmacie;
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
BUSINESS for table "pharmacie"
 * 
 * @author Geo
 *
 */

@Component
public class PharmacieBusiness implements IBasicBusiness<Request<PharmacieDto>, Response<PharmacieDto>> {

	private Response<PharmacieDto> response;
	@Autowired
	private PharmacieRepository pharmacieRepository;
	@Autowired
	private MinioExternalService minioExternalService;
	@Autowired
	private PrixMedicamentRepository prixMedicamentRepository;
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

	public PharmacieBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Pharmacie by using PharmacieDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacieDto> create(Request<PharmacieDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Pharmacie-----");

		Response<PharmacieDto> response = new Response<PharmacieDto>();
		List<Pharmacie>        items    = new ArrayList<Pharmacie>();
			
		for (PharmacieDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("nom", dto.getNom());
			fieldsToVerify.put("adresse", dto.getAdresse());
			fieldsToVerify.put("latitude", dto.getLatitude());
			fieldsToVerify.put("longitude", dto.getLongitude());
			fieldsToVerify.put("telephone", dto.getTelephone());
			fieldsToVerify.put("email", dto.getEmail());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}
			// Verify if pharmacie to insert do not exist
			Pharmacie existingEntity = null;
			// verif unique email in db
			existingEntity = pharmacieRepository.findByEmail(dto.getEmail(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("pharmacie email -> " + dto.getEmail(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" email ", locale));
				response.setHasError(true);
				return response;
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
				dto.setImagesUrl(listUrl.toString());
			}
			Pharmacie entityToSave = null;
			entityToSave = PharmacieTransformer.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Pharmacie> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = pharmacieRepository.saveAll((Iterable<Pharmacie>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("pharmacie", locale));
				response.setHasError(true);
				return response;
			}
			List<PharmacieDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmacieTransformer.toLiteDtos(itemsSaved) : PharmacieTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Pharmacie-----");
		return response;
	}

	/**
	 * update Pharmacie by using PharmacieDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacieDto> update(Request<PharmacieDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Pharmacie-----");

		Response<PharmacieDto> response = new Response<PharmacieDto>();
		List<Pharmacie>        items    = new ArrayList<Pharmacie>();
			
		for (PharmacieDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la pharmacie existe
			Pharmacie entityToSave = null;
			entityToSave = pharmacieRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("pharmacie id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getNom())) {
				entityToSave.setNom(dto.getNom());
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
			if (Utilities.notBlank(dto.getTelephone())) {
				entityToSave.setTelephone(dto.getTelephone());
			}
			if (Utilities.notBlank(dto.getEmail())) {
				entityToSave.setEmail(dto.getEmail());
			}
			if (Utilities.notBlank(dto.getHorairesOuverture())) {
				entityToSave.setHorairesOuverture(dto.getHorairesOuverture());
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
			List<Pharmacie> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = pharmacieRepository.saveAll((Iterable<Pharmacie>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("pharmacie", locale));
				response.setHasError(true);
				return response;
			}
			List<PharmacieDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmacieTransformer.toLiteDtos(itemsSaved) : PharmacieTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Pharmacie-----");
		return response;
	}

	/**
	 * delete Pharmacie by using PharmacieDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacieDto> delete(Request<PharmacieDto> request, Locale locale)  {
		// System.out.println("----begin delete Pharmacie-----");

		Response<PharmacieDto> response = new Response<PharmacieDto>();
		List<Pharmacie>        items    = new ArrayList<Pharmacie>();
			
		for (PharmacieDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la pharmacie existe
			Pharmacie existingEntity = null;

			existingEntity = pharmacieRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("pharmacie -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// prixMedicament
			List<PrixMedicament> listOfPrixMedicament = prixMedicamentRepository.findByPharmacieId(existingEntity.getId(), false);
			if (listOfPrixMedicament != null && !listOfPrixMedicament.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrixMedicament.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// commande
			List<Commande> listOfCommande = commandeRepository.findByPharmacieId(existingEntity.getId(), false);
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
			pharmacieRepository.saveAll((Iterable<Pharmacie>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Pharmacie-----");
		return response;
	}

	/**
	 * get Pharmacie by using PharmacieDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacieDto> getByCriteria(Request<PharmacieDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Pharmacie-----");

		Response<PharmacieDto> response = new Response<PharmacieDto>();
		List<Pharmacie> items 			 = pharmacieRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PharmacieDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmacieTransformer.toLiteDtos(items) : PharmacieTransformer.toDtos(items);

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
			response.setCount(pharmacieRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("pharmacie", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Pharmacie-----");
		return response;
	}

	/**
	 * get full PharmacieDto by using Pharmacie as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PharmacieDto getFullInfos(PharmacieDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
