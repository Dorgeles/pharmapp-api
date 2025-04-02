                                                                    																
/*
 * Java business for entity table commande 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
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
BUSINESS for table "commande"
 * 
 * @author Geo
 *
 */

@Component
public class CommandeBusiness implements IBasicBusiness<Request<CommandeDto>, Response<CommandeDto>> {

	private Response<CommandeDto> response;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private PharmacieRepository pharmacieRepository;
	@Autowired
	private AssurancesRepository assurancesRepository;
	@Autowired
	private OrdonnanceRepository ordonnanceRepository;
	@Autowired
	private AdresseRepository adresseRepository;
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

	public CommandeBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Commande by using CommandeDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandeDto> create(Request<CommandeDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Commande-----");

		Response<CommandeDto> response = new Response<CommandeDto>();
		List<Commande>        items    = new ArrayList<Commande>();
			
		for (CommandeDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("modeRecuperation", dto.getModeRecuperation());
			fieldsToVerify.put("userId", dto.getUserId());
			fieldsToVerify.put("ordonnanceId", dto.getOrdonnanceId());
			fieldsToVerify.put("pharmacieId", dto.getPharmacieId());
			//fieldsToVerify.put("adresseId", dto.getAdresseId());
			//fieldsToVerify.put("assuranceId", dto.getAssuranceId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if commande to insert do not exist
			Commande existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("commande id -> " + dto.getId(), locale));
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
			// Verify if assurances exist
			Assurances existingAssurances = null;
			if (dto.getAssuranceId() != null && dto.getAssuranceId() > 0){
				existingAssurances = assurancesRepository.findOne(dto.getAssuranceId(), false);
				if (existingAssurances == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("assurances assuranceId -> " + dto.getAssuranceId(), locale));
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
			// Verify if adresse exist
			Adresse existingAdresse = null;
			if (dto.getAdresseId() != null && dto.getAdresseId() > 0){
				existingAdresse = adresseRepository.findOne(dto.getAdresseId(), false);
				if (existingAdresse == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("adresse adresseId -> " + dto.getAdresseId(), locale));
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
				Commande entityToSave = null;
			entityToSave = CommandeTransformer.toEntity(dto, existingPharmacie, existingAssurances, existingOrdonnance, existingAdresse, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Commande> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = commandeRepository.saveAll((Iterable<Commande>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("commande", locale));
				response.setHasError(true);
				return response;
			}
			List<CommandeDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CommandeTransformer.toLiteDtos(itemsSaved) : CommandeTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end create Commande-----");
		return response;
	}

	/**
	 * update Commande by using CommandeDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandeDto> update(Request<CommandeDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Commande-----");

		Response<CommandeDto> response = new Response<CommandeDto>();
		List<Commande>        items    = new ArrayList<Commande>();
			
		for (CommandeDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la commande existe
			Commande entityToSave = null;
			entityToSave = commandeRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("commande id -> " + dto.getId(), locale));
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
			// Verify if assurances exist
			if (dto.getAssuranceId() != null && dto.getAssuranceId() > 0){
				Assurances existingAssurances = assurancesRepository.findOne(dto.getAssuranceId(), false);
				if (existingAssurances == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("assurances assuranceId -> " + dto.getAssuranceId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setAssurances(existingAssurances);
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
			// Verify if adresse exist
			if (dto.getAdresseId() != null && dto.getAdresseId() > 0){
				Adresse existingAdresse = adresseRepository.findOne(dto.getAdresseId(), false);
				if (existingAdresse == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("adresse adresseId -> " + dto.getAdresseId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setAdresse(existingAdresse);
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
			if (Utilities.notBlank(dto.getPrixTotal())) {
				entityToSave.setPrixTotal(dto.getPrixTotal());
			}
			if (Utilities.notBlank(dto.getModeRecuperation())) {
				entityToSave.setModeRecuperation(dto.getModeRecuperation());
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
			List<Commande> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = commandeRepository.saveAll((Iterable<Commande>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("commande", locale));
				response.setHasError(true);
				return response;
			}
			List<CommandeDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CommandeTransformer.toLiteDtos(itemsSaved) : CommandeTransformer.toDtos(itemsSaved);

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

		// System.out.println("----end update Commande-----");
		return response;
	}

	/**
	 * delete Commande by using CommandeDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandeDto> delete(Request<CommandeDto> request, Locale locale)  {
		// System.out.println("----begin delete Commande-----");

		Response<CommandeDto> response = new Response<CommandeDto>();
		List<Commande>        items    = new ArrayList<Commande>();
			
		for (CommandeDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la commande existe
			Commande existingEntity = null;

			existingEntity = commandeRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("commande -> " + dto.getId(), locale));
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
			commandeRepository.saveAll((Iterable<Commande>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Commande-----");
		return response;
	}

	/**
	 * get Commande by using CommandeDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandeDto> getByCriteria(Request<CommandeDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Commande-----");

		Response<CommandeDto> response = new Response<CommandeDto>();
		List<Commande> items 			 = commandeRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<CommandeDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CommandeTransformer.toLiteDtos(items) : CommandeTransformer.toDtos(items);

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
			response.setCount(commandeRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("commande", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Commande-----");
		return response;
	}

	/**
	 * get full CommandeDto by using Commande as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private CommandeDto getFullInfos(CommandeDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
