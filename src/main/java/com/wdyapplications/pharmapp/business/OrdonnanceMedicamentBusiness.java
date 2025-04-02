                                                    												
/*
 * Java business for entity table ordonnance_medicament 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Medicament;
import com.wdyapplications.pharmapp.dao.entity.Ordonnance;
import com.wdyapplications.pharmapp.dao.entity.OrdonnanceMedicament;
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
BUSINESS for table "ordonnance_medicament"
 * 
 * @author Geo
 *
 */

@Component
public class OrdonnanceMedicamentBusiness implements IBasicBusiness<Request<OrdonnanceMedicamentDto>, Response<OrdonnanceMedicamentDto>> {

	private Response<OrdonnanceMedicamentDto> response;
	@Autowired
	private OrdonnanceMedicamentRepository ordonnanceMedicamentRepository;
	@Autowired
	private MedicamentRepository medicamentRepository;
	@Autowired
	private OrdonnanceRepository ordonnanceRepository;
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

	public OrdonnanceMedicamentBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create OrdonnanceMedicament by using OrdonnanceMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceMedicamentDto> create(Request<OrdonnanceMedicamentDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create OrdonnanceMedicament-----");

		Response<OrdonnanceMedicamentDto> response = new Response<OrdonnanceMedicamentDto>();
		List<OrdonnanceMedicament>        items    = new ArrayList<OrdonnanceMedicament>();
			
		for (OrdonnanceMedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("ordonnanceId", dto.getOrdonnanceId());
			fieldsToVerify.put("medicamentId", dto.getMedicamentId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if ordonnanceMedicament to insert do not exist
			OrdonnanceMedicament existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("ordonnanceMedicament id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
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
			// Verify if ordonnance exist
			Ordonnance existingOrdonnance = null;
			if (dto.getOrdonnanceId() != null && dto.getOrdonnanceId() > 0){
				existingOrdonnance = ordonnanceRepository.findOne(dto.getOrdonnanceId(), false);
				if (existingOrdonnance == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("ordonnance ordonnanceId -> " + dto.getOrdonnanceId(), locale));
					response.setHasError(true);
					return response;
				}
			}

			// ajout de la quantité
				OrdonnanceMedicament entityToSave = null;
			entityToSave = OrdonnanceMedicamentTransformer.toEntity(dto, existingMedicament, existingOrdonnance);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<OrdonnanceMedicament> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = ordonnanceMedicamentRepository.saveAll((Iterable<OrdonnanceMedicament>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("ordonnanceMedicament", locale));
				response.setHasError(true);
				return response;
			}
			List<OrdonnanceMedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdonnanceMedicamentTransformer.toLiteDtos(itemsSaved) : OrdonnanceMedicamentTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create OrdonnanceMedicament-----");
		return response;
	}

	/**
	 * update OrdonnanceMedicament by using OrdonnanceMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceMedicamentDto> update(Request<OrdonnanceMedicamentDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update OrdonnanceMedicament-----");

		Response<OrdonnanceMedicamentDto> response = new Response<OrdonnanceMedicamentDto>();
		List<OrdonnanceMedicament>        items    = new ArrayList<OrdonnanceMedicament>();
			
		for (OrdonnanceMedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la ordonnanceMedicament existe
			OrdonnanceMedicament entityToSave = null;
			entityToSave = ordonnanceMedicamentRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("ordonnanceMedicament id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
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
			// Verify if ordonnance exist
			if (dto.getOrdonnanceId() != null && dto.getOrdonnanceId() > 0){
				Ordonnance existingOrdonnance = ordonnanceRepository.findOne(dto.getOrdonnanceId(), false);
				if (existingOrdonnance == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("ordonnance ordonnanceId -> " + dto.getOrdonnanceId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setOrdonnance(existingOrdonnance);
			}
			if (dto.getQuantite() != null && dto.getQuantite() > 0) {
				entityToSave.setQuantite(dto.getQuantite());
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
			List<OrdonnanceMedicament> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = ordonnanceMedicamentRepository.saveAll((Iterable<OrdonnanceMedicament>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("ordonnanceMedicament", locale));
				response.setHasError(true);
				return response;
			}
			List<OrdonnanceMedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdonnanceMedicamentTransformer.toLiteDtos(itemsSaved) : OrdonnanceMedicamentTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update OrdonnanceMedicament-----");
		return response;
	}

	/**
	 * delete OrdonnanceMedicament by using OrdonnanceMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceMedicamentDto> delete(Request<OrdonnanceMedicamentDto> request, Locale locale)  {
		// System.out.println("----begin delete OrdonnanceMedicament-----");

		Response<OrdonnanceMedicamentDto> response = new Response<OrdonnanceMedicamentDto>();
		List<OrdonnanceMedicament>        items    = new ArrayList<OrdonnanceMedicament>();
			
		for (OrdonnanceMedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la ordonnanceMedicament existe
			OrdonnanceMedicament existingEntity = null;

			existingEntity = ordonnanceMedicamentRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("ordonnanceMedicament -> " + dto.getId(), locale));
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
			ordonnanceMedicamentRepository.saveAll((Iterable<OrdonnanceMedicament>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete OrdonnanceMedicament-----");
		return response;
	}

	/**
	 * get OrdonnanceMedicament by using OrdonnanceMedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdonnanceMedicamentDto> getByCriteria(Request<OrdonnanceMedicamentDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get OrdonnanceMedicament-----");

		Response<OrdonnanceMedicamentDto> response = new Response<OrdonnanceMedicamentDto>();
		List<OrdonnanceMedicament> items 			 = ordonnanceMedicamentRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<OrdonnanceMedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdonnanceMedicamentTransformer.toLiteDtos(items) : OrdonnanceMedicamentTransformer.toDtos(items);

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
			response.setCount(ordonnanceMedicamentRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("ordonnanceMedicament", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get OrdonnanceMedicament-----");
		return response;
	}

	/**
	 * get full OrdonnanceMedicamentDto by using OrdonnanceMedicament as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private OrdonnanceMedicamentDto getFullInfos(OrdonnanceMedicamentDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
