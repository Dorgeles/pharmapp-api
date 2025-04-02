
package com.wdyapplications.pharmapp.dao.repository.base;

import com.wdyapplications.pharmapp.dao.entity.*;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.contract.Request;
import com.wdyapplications.pharmapp.utils.dto.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.*;

/**
 * Repository customize : Roles.
 *
 * @author Geo
 *
 */
@Repository
public interface _RolesRepository {
	    /**
     * Finds Roles by using id as a search criteria.
     *
     * @param id
     * @return An Object Roles whose id is equals to the given id. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.id = :id and e.isDeleted = :isDeleted")
    Roles findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Roles by using libelle as a search criteria.
     *
     * @param libelle
     * @return An Object Roles whose libelle is equals to the given libelle. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.libelle = :libelle and e.isDeleted = :isDeleted")
    Roles findByLibelle(@Param("libelle")String libelle, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using commentaire as a search criteria.
     *
     * @param commentaire
     * @return An Object Roles whose commentaire is equals to the given commentaire. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.commentaire = :commentaire and e.isDeleted = :isDeleted")
    List<Roles> findByCommentaire(@Param("commentaire")String commentaire, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Roles whose createdAt is equals to the given createdAt. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Roles> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Roles whose createdBy is equals to the given createdBy. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Roles> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Roles whose deletedAt is equals to the given deletedAt. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Roles> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Roles whose isDeleted is equals to the given isDeleted. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.isDeleted = :isDeleted")
    List<Roles> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Roles whose statusId is equals to the given statusId. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Roles> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Roles whose updatedAt is equals to the given updatedAt. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Roles> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Roles by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Roles whose updatedBy is equals to the given updatedBy. If
     *         no Roles is found, this method returns null.
     */
    @Query("select e from Roles e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Roles> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Roles by using rolesDto as a search criteria.
     *
     * @param request, em
     * @return A List of Roles
     * @throws DataAccessException,ParseException
     */
    public default List<Roles> getByCriteria(Request<RolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Roles e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Roles> query = em.createQuery(req, Roles.class);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        if (request.getIndex() != null && request.getSize() != null) {
            query.setFirstResult(request.getIndex() * request.getSize());
            query.setMaxResults(request.getSize());
        }
        return query.getResultList();
    }

    /**
     * Finds count of Roles by using rolesDto as a search criteria.
     *
     * @param request, em
     * @return Number of Roles
     *
     */
    public default Long count(Request<RolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Roles e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                jakarta.persistence.Query query = em.createQuery(req);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        Long count = (Long) query.getResultList().get(0);
        return count;
    }

    /**
     * get where expression
     * @param request
     * @param param
     * @param locale
     * @return
     * @throws Exception
     */
    default String getWhereExpression(Request<RolesDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        RolesDto dto = request.getData() != null ? request.getData() : new RolesDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (RolesDto elt : request.getDatas()) {
                elt.setIsDeleted(false);
                String eltReq = generateCriteria(elt, param, index, locale);
                if (request.getIsAnd() != null && request.getIsAnd()) {
                    othersReq += "and (" + eltReq + ") ";
                } else {
                    othersReq += "or (" + eltReq + ") ";
                }
                index++;
            }
        }
        String req = "";
        if (!mainReq.isEmpty()) {
            req += " and (" + mainReq + ") ";
        }
        req += othersReq;

        //order
        if(Direction.fromOptionalString(dto.getOrderDirection()).orElse(null) != null && Utilities.notBlank(dto.getOrderField())) {
            req += " group by  e.id";
            req += " order by e." + dto.getOrderField() + " " + dto.getOrderDirection();
        } else {
            req += " group by  e.id";
            req += " order by  e.id desc";
        }
        return req;
    }

    /**
     * generate sql query for dto
     * @param dto
     * @param param
     * @param index
     * @param locale
     * @return
     * @throws Exception
     */
    default String generateCriteria(RolesDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLibelle()) || Utilities.searchParamIsNotEmpty(dto.getLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("libelle", dto.getLibelle(), "e.libelle", "String", dto.getLibelleParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCommentaire()) || Utilities.searchParamIsNotEmpty(dto.getCommentaireParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("commentaire", dto.getCommentaire(), "e.commentaire", "String", dto.getCommentaireParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCreatedAt()) || Utilities.searchParamIsNotEmpty(dto.getCreatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
            }
            if (dto.getCreatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getCreatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdBy", dto.getCreatedBy(), "e.createdBy", "Integer", dto.getCreatedByParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDeletedAt()) || Utilities.searchParamIsNotEmpty(dto.getDeletedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("deletedAt", dto.getDeletedAt(), "e.deletedAt", "Date", dto.getDeletedAtParam(), param, index, locale));
            }
            if (dto.getIsDeleted() != null || Utilities.searchParamIsNotEmpty(dto.getIsDeletedParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("isDeleted", dto.getIsDeleted(), "e.isDeleted", "Boolean", dto.getIsDeletedParam(), param, index, locale));
            }
            if (dto.getStatusId() != null || Utilities.searchParamIsNotEmpty(dto.getStatusIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("statusId", dto.getStatusId(), "e.statusId", "Integer", dto.getStatusIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUpdatedAt()) || Utilities.searchParamIsNotEmpty(dto.getUpdatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
            }
            if (dto.getUpdatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getUpdatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedBy", dto.getUpdatedBy(), "e.updatedBy", "Integer", dto.getUpdatedByParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
