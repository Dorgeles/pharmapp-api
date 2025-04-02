                                                											
/*
 * Java business for entity table roles
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business;


import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.dao.entity.Roles;
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
 * BUSINESS for table "roles"
 *
 * @author Geo
 */

@Component
public class RolesBusiness implements IBasicBusiness<Request<RolesDto>, Response<RolesDto>> {

    private Response<RolesDto> response;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;
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

    public RolesBusiness() {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    /**
     * create Roles by using RolesDto as object.
     *
     * @param request
     * @return response
     */
    @Override
    public Response<RolesDto> create(Request<RolesDto> request, Locale locale) throws ParseException {
        // System.out.println("----begin create Roles-----");

        Response<RolesDto> response = new Response<RolesDto>();
        List<Roles> items = new ArrayList<Roles>();

        for (RolesDto dto : request.getDatas()) {
            // Definir les parametres obligatoires
            Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
            fieldsToVerify.put("libelle", dto.getLibelle());
            fieldsToVerify.put("commentaire", dto.getCommentaire());
            if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
                response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
                response.setHasError(true);
                return response;
            }

            // Verify if roles to insert do not exist
            Roles existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("roles id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
            // verif unique libelle in db
            existingEntity = rolesRepository.findByLibelle(dto.getLibelle(), false);
            if (existingEntity != null) {
                response.setStatus(functionalError.DATA_EXIST("roles libelle -> " + dto.getLibelle(), locale));
                response.setHasError(true);
                return response;
            }
            // verif unique libelle in items to save
            if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
                response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
                response.setHasError(true);
                return response;
            }

            Roles entityToSave = null;
            entityToSave = RolesTransformer.toEntity(dto);
            entityToSave.setCreatedAt(Utilities.getCurrentDate());
            entityToSave.setCreatedBy(request.getUser());
            entityToSave.setIsDeleted(false);
            entityToSave.setStatusId(StatusEnum.ACTIVE);
            items.add(entityToSave);
        }

        if (!items.isEmpty()) {
            List<Roles> itemsSaved = null;
            // inserer les donnees en base de donnees
            itemsSaved = rolesRepository.saveAll((Iterable<Roles>) items);
            if (itemsSaved == null) {
                response.setStatus(functionalError.SAVE_FAIL("roles", locale));
                response.setHasError(true);
                return response;
            }
            List<RolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RolesTransformer.toLiteDtos(itemsSaved) : RolesTransformer.toDtos(itemsSaved);

            final int size = itemsSaved.size();
            List<String> listOfError = Collections.synchronizedList(new ArrayList<String>());
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

        // System.out.println("----end create Roles-----");
        return response;
    }

    /**
     * update Roles by using RolesDto as object.
     *
     * @param request
     * @return response
     */
    @Override
    public Response<RolesDto> update(Request<RolesDto> request, Locale locale) throws ParseException {
        // System.out.println("----begin update Roles-----");

        Response<RolesDto> response = new Response<RolesDto>();
        List<Roles> items = new ArrayList<Roles>();

        for (RolesDto dto : request.getDatas()) {
            // Definir les parametres obligatoires
            Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
            fieldsToVerify.put("id", dto.getId());
            if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
                response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
                response.setHasError(true);
                return response;
            }

            // Verifier si la roles existe
            Roles entityToSave = null;
            entityToSave = rolesRepository.findOne(dto.getId(), false);
            if (entityToSave == null) {
                response.setStatus(functionalError.DATA_NOT_EXIST("roles id -> " + dto.getId(), locale));
                response.setHasError(true);
                return response;
            }

            if (Utilities.notBlank(dto.getLibelle())) {
                entityToSave.setLibelle(dto.getLibelle());
            }
            if (Utilities.notBlank(dto.getCommentaire())) {
                entityToSave.setCommentaire(dto.getCommentaire());
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
            List<Roles> itemsSaved = null;
            // maj les donnees en base
            itemsSaved = rolesRepository.saveAll((Iterable<Roles>) items);
            if (itemsSaved == null) {
                response.setStatus(functionalError.SAVE_FAIL("roles", locale));
                response.setHasError(true);
                return response;
            }
            List<RolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RolesTransformer.toLiteDtos(itemsSaved) : RolesTransformer.toDtos(itemsSaved);

            final int size = itemsSaved.size();
            List<String> listOfError = Collections.synchronizedList(new ArrayList<String>());
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

        // System.out.println("----end update Roles-----");
        return response;
    }

    /**
     * delete Roles by using RolesDto as object.
     *
     * @param request
     * @return response
     */
    @Override
    public Response<RolesDto> delete(Request<RolesDto> request, Locale locale) {
        // System.out.println("----begin delete Roles-----");

        Response<RolesDto> response = new Response<RolesDto>();
        List<Roles> items = new ArrayList<Roles>();

        for (RolesDto dto : request.getDatas()) {
            // Definir les parametres obligatoires
            Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
            fieldsToVerify.put("id", dto.getId());
            if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
                response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
                response.setHasError(true);
                return response;
            }

            // Verifier si la roles existe
            Roles existingEntity = null;

            existingEntity = rolesRepository.findOne(dto.getId(), false);
            if (existingEntity == null) {
                response.setStatus(functionalError.DATA_NOT_EXIST("roles -> " + dto.getId(), locale));
                response.setHasError(true);
                return response;
            }

            // -----------------------------------------------------------------------
            // ----------- CHECK IF DATA IS USED
            // -----------------------------------------------------------------------

            // userRoles
            List<UserRoles> listOfUserRoles = userRolesRepository.findByRoleId(existingEntity.getId(), false);
            if (listOfUserRoles != null && !listOfUserRoles.isEmpty()) {
                response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserRoles.size() + ")", locale));
                response.setHasError(true);
                return response;
            }


            existingEntity.setDeletedAt(Utilities.getCurrentDate());
            existingEntity.setIsDeleted(true);
            items.add(existingEntity);
        }

        if (!items.isEmpty()) {
            // supprimer les donnees en base
            rolesRepository.saveAll((Iterable<Roles>) items);

            response.setHasError(false);
        }

        // System.out.println("----end delete Roles-----");
        return response;
    }

    /**
     * get Roles by using RolesDto as object.
     *
     * @param request
     * @return response
     */
    @Override
    public Response<RolesDto> getByCriteria(Request<RolesDto> request, Locale locale) throws Exception {
        // System.out.println("----begin get Roles-----");

        Response<RolesDto> response = new Response<RolesDto>();
        List<Roles> items = rolesRepository.getByCriteria(request, em, locale);

        if (items != null && !items.isEmpty()) {
            List<RolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RolesTransformer.toLiteDtos(items) : RolesTransformer.toDtos(items);

            final int size = items.size();
            List<String> listOfError = Collections.synchronizedList(new ArrayList<String>());
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
            response.setCount(rolesRepository.count(request, em, locale));
            response.setHasError(false);
        } else {
            response.setStatus(functionalError.DATA_EMPTY("roles", locale));
            response.setHasError(false);
            return response;
        }

        // System.out.println("----end get Roles-----");
        return response;
    }

    /**
     * get full RolesDto by using Roles as object.
     *
     * @param dto
     * @param size
     * @param isSimpleLoading
     * @param locale
     * @return
     * @throws Exception
     */
    public RolesDto getFullInfos(RolesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
