                                                    												
/*
 * Java business for entity table prix_medicament 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Medicament;
import com.wdyapplications.pharmapp.dao.entity.Pharmacie;
import com.wdyapplications.pharmapp.dao.entity.PrixMedicament;
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
BUSINESS for table "prix_medicament"
 * 
 * @author Geo
 *
 */

@Component
public class PrixMedicamentBusiness implements IBasicBusiness<Request<PrixMedicamentDto>, Response<PrixMedicamentDto>> {

	private Response<PrixMedicamentDto> response;
	@Autowired
	private PrixMedicamentRepository prixMedicamentRepository;
	@Autowired
	private PharmacieRepository pharmacieRepository;
	@Autowired
	private MedicamentRepository medicamentRepository;
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

	public PrixMedicamentBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PrixMedicament by using PrixMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrixMedicamentDto> create(Request<PrixMedicamentDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create PrixMedicament-----");

		Response<PrixMedicamentDto> response = new Response<PrixMedicamentDto>();
		List<PrixMedicament>        items    = new ArrayList<PrixMedicament>();
			
		for (PrixMedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("medicamentId", dto.getMedicamentId());
			fieldsToVerify.put("pharmacieId", dto.getPharmacieId());
			fieldsToVerify.put("prixUnitaire", dto.getPrixUnitaire());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if prixMedicament to insert do not exist
			PrixMedicament existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prixMedicament id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if pharmacie exist
			Pharmacie existingPharmacie = null;
			if (dto.getPharmacieId() != null && dto.getPharmacieId() > 0){
				existingPharmacie = pharmacieRepository.findOne(dto.getPharmacieId(), false);
				if (existingPharmacie == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("pharmacie pharmacieId -> " + dto.getPharmacieId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if medicament exist
			Medicament existingMedicament = null;
			if (dto.getMedicamentId() != null && dto.getMedicamentId() > 0){
				existingMedicament = medicamentRepository.findOne(dto.getMedicamentId(), false);
				if (existingMedicament == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("medicament medicamentId -> " + dto.getMedicamentId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				PrixMedicament entityToSave = null;
			entityToSave = PrixMedicamentTransformer.toEntity(dto, existingPharmacie, existingMedicament);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PrixMedicament> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = prixMedicamentRepository.saveAll((Iterable<PrixMedicament>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prixMedicament", locale));
				response.setHasError(true);
				return response;
			}
			List<PrixMedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrixMedicamentTransformer.toLiteDtos(itemsSaved) : PrixMedicamentTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create PrixMedicament-----");
		return response;
	}

	/**
	 * update PrixMedicament by using PrixMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrixMedicamentDto> update(Request<PrixMedicamentDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update PrixMedicament-----");

		Response<PrixMedicamentDto> response = new Response<PrixMedicamentDto>();
		List<PrixMedicament>        items    = new ArrayList<PrixMedicament>();
			
		for (PrixMedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prixMedicament existe
			PrixMedicament entityToSave = null;
			entityToSave = prixMedicamentRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prixMedicament id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if pharmacie exist
			if (dto.getPharmacieId() != null && dto.getPharmacieId() > 0){
				Pharmacie existingPharmacie = pharmacieRepository.findOne(dto.getPharmacieId(), false);
				if (existingPharmacie == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("pharmacie pharmacieId -> " + dto.getPharmacieId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setPharmacie(existingPharmacie);
			}
			// Verify if medicament exist
			if (dto.getMedicamentId() != null && dto.getMedicamentId() > 0){
				Medicament existingMedicament = medicamentRepository.findOne(dto.getMedicamentId(), false);
				if (existingMedicament == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("medicament medicamentId -> " + dto.getMedicamentId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setMedicament(existingMedicament);
			}
			if (Utilities.notBlank(dto.getPrixUnitaire())) {
				entityToSave.setPrixUnitaire(dto.getPrixUnitaire());
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
			List<PrixMedicament> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = prixMedicamentRepository.saveAll((Iterable<PrixMedicament>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prixMedicament", locale));
				response.setHasError(true);
				return response;
			}
			List<PrixMedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrixMedicamentTransformer.toLiteDtos(itemsSaved) : PrixMedicamentTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update PrixMedicament-----");
		return response;
	}

	/**
	 * delete PrixMedicament by using PrixMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrixMedicamentDto> delete(Request<PrixMedicamentDto> request, Locale locale)  {
		// System.out.println("----begin delete PrixMedicament-----");

		Response<PrixMedicamentDto> response = new Response<PrixMedicamentDto>();
		List<PrixMedicament>        items    = new ArrayList<PrixMedicament>();
			
		for (PrixMedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prixMedicament existe
			PrixMedicament existingEntity = null;

			existingEntity = prixMedicamentRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prixMedicament -> " + dto.getId(), locale));
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
			prixMedicamentRepository.saveAll((Iterable<PrixMedicament>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete PrixMedicament-----");
		return response;
	}

	/**
	 * get PrixMedicament by using PrixMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrixMedicamentDto> getByCriteria(Request<PrixMedicamentDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get PrixMedicament-----");

		Response<PrixMedicamentDto> response = new Response<PrixMedicamentDto>();
		List<PrixMedicament> items 			 = prixMedicamentRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PrixMedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrixMedicamentTransformer.toLiteDtos(items) : PrixMedicamentTransformer.toDtos(items);

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
			response.setCount(prixMedicamentRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("prixMedicament", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get PrixMedicament-----");
		return response;
	}

	/**
	 * get full PrixMedicamentDto by using PrixMedicament as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PrixMedicamentDto getFullInfos(PrixMedicamentDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
