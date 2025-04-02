                                                                    																
/*
 * Java business for entity table medicament 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Medicament;
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
BUSINESS for table "medicament"
 * 
 * @author Geo
 *
 */

@Component
public class MedicamentBusiness implements IBasicBusiness<Request<MedicamentDto>, Response<MedicamentDto>> {

	private Response<MedicamentDto> response;
	@Autowired
	private MedicamentRepository medicamentRepository;
	@Autowired
	private OrdonnanceMedicamentRepository ordonnanceMedicamentRepository;
	@Autowired
	private PrixMedicamentRepository prixMedicamentRepository;
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

	public MedicamentBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Medicament by using MedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MedicamentDto> create(Request<MedicamentDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Medicament-----");

		Response<MedicamentDto> response = new Response<MedicamentDto>();
		List<Medicament>        items    = new ArrayList<Medicament>();
			
		for (MedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("dosage", dto.getDosage());
			fieldsToVerify.put("formePharmaceutique", dto.getFormePharmaceutique());
			fieldsToVerify.put("plafondPrix", dto.getPlafondPrix());
			fieldsToVerify.put("principeActif", dto.getPrincipeActif());
			fieldsToVerify.put("laboratoire", dto.getLaboratoire());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if medicament to insert do not exist
			Medicament existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("medicament id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			Medicament entityToSave = null;
			entityToSave = MedicamentTransformer.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Medicament> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = medicamentRepository.saveAll((Iterable<Medicament>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("medicament", locale));
				response.setHasError(true);
				return response;
			}
			List<MedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MedicamentTransformer.toLiteDtos(itemsSaved) : MedicamentTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Medicament-----");
		return response;
	}

	/**
	 * update Medicament by using MedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MedicamentDto> update(Request<MedicamentDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Medicament-----");

		Response<MedicamentDto> response = new Response<MedicamentDto>();
		List<Medicament>        items    = new ArrayList<Medicament>();
			
		for (MedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la medicament existe
			Medicament entityToSave = null;
			entityToSave = medicamentRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("medicament id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
			}
			if (Utilities.notBlank(dto.getDosage())) {
				entityToSave.setDosage(dto.getDosage());
			}
			if (Utilities.notBlank(dto.getFormePharmaceutique())) {
				entityToSave.setFormePharmaceutique(dto.getFormePharmaceutique());
			}
			if (Utilities.notBlank(dto.getPlafondPrix())) {
				entityToSave.setPlafondPrix(dto.getPlafondPrix());
			}
			if (Utilities.notBlank(dto.getPrincipeActif())) {
				entityToSave.setPrincipeActif(dto.getPrincipeActif());
			}
			if (Utilities.notBlank(dto.getLaboratoire())) {
				entityToSave.setLaboratoire(dto.getLaboratoire());
			}
			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
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
			List<Medicament> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = medicamentRepository.saveAll((Iterable<Medicament>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("medicament", locale));
				response.setHasError(true);
				return response;
			}
			List<MedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MedicamentTransformer.toLiteDtos(itemsSaved) : MedicamentTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Medicament-----");
		return response;
	}

	/**
	 * delete Medicament by using MedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MedicamentDto> delete(Request<MedicamentDto> request, Locale locale)  {
		// System.out.println("----begin delete Medicament-----");

		Response<MedicamentDto> response = new Response<MedicamentDto>();
		List<Medicament>        items    = new ArrayList<Medicament>();
			
		for (MedicamentDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la medicament existe
			Medicament existingEntity = null;

			existingEntity = medicamentRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("medicament -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// ordonnanceMedicament
			List<OrdonnanceMedicament> listOfOrdonnanceMedicament = ordonnanceMedicamentRepository.findByMedicamentId(existingEntity.getId(), false);
			if (listOfOrdonnanceMedicament != null && !listOfOrdonnanceMedicament.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfOrdonnanceMedicament.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// prixMedicament
			List<PrixMedicament> listOfPrixMedicament = prixMedicamentRepository.findByMedicamentId(existingEntity.getId(), false);
			if (listOfPrixMedicament != null && !listOfPrixMedicament.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrixMedicament.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setIsDeleted(true);
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			medicamentRepository.saveAll((Iterable<Medicament>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Medicament-----");
		return response;
	}

	/**
	 * get Medicament by using MedicamentDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MedicamentDto> getByCriteria(Request<MedicamentDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Medicament-----");

		Response<MedicamentDto> response = new Response<MedicamentDto>();
		List<Medicament> items 			 = medicamentRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<MedicamentDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MedicamentTransformer.toLiteDtos(items) : MedicamentTransformer.toDtos(items);

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
			response.setCount(medicamentRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("medicament", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Medicament-----");
		return response;
	}

	/**
	 * get full MedicamentDto by using Medicament as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private MedicamentDto getFullInfos(MedicamentDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
