
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
 * Repository customize : OrdonnanceMedicament.
 *
 * @author Geo
 *
 */
@Repository
public interface _OrdonnanceMedicamentRepository {
	    /**
     * Finds OrdonnanceMedicament by using id as a search criteria.
     *
     * @param id
     * @return An Object OrdonnanceMedicament whose id is equals to the given id. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.id = :id and e.isDeleted = :isDeleted")
    OrdonnanceMedicament findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds OrdonnanceMedicament by using quantite as a search criteria.
     *
     * @param quantite
     * @return An Object OrdonnanceMedicament whose quantite is equals to the given quantite. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.quantite = :quantite and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByQuantite(@Param("quantite")Integer quantite, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object OrdonnanceMedicament whose createdAt is equals to the given createdAt. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object OrdonnanceMedicament whose createdBy is equals to the given createdBy. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object OrdonnanceMedicament whose deletedAt is equals to the given deletedAt. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object OrdonnanceMedicament whose isDeleted is equals to the given isDeleted. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object OrdonnanceMedicament whose statusId is equals to the given statusId. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object OrdonnanceMedicament whose updatedAt is equals to the given updatedAt. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds OrdonnanceMedicament by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object OrdonnanceMedicament whose updatedBy is equals to the given updatedBy. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds OrdonnanceMedicament by using medicamentId as a search criteria.
     *
     * @param medicamentId
     * @return An Object OrdonnanceMedicament whose medicamentId is equals to the given medicamentId. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.medicament.id = :medicamentId and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByMedicamentId(@Param("medicamentId")Integer medicamentId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one OrdonnanceMedicament by using medicamentId as a search criteria.
   *
   * @param medicamentId
   * @return An Object OrdonnanceMedicament whose medicamentId is equals to the given medicamentId. If
   *         no OrdonnanceMedicament is found, this method returns null.
   */
  @Query("select e from OrdonnanceMedicament e where e.medicament.id = :medicamentId and e.isDeleted = :isDeleted")
  OrdonnanceMedicament findOrdonnanceMedicamentByMedicamentId(@Param("medicamentId")Integer medicamentId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds OrdonnanceMedicament by using ordonnanceId as a search criteria.
     *
     * @param ordonnanceId
     * @return An Object OrdonnanceMedicament whose ordonnanceId is equals to the given ordonnanceId. If
     *         no OrdonnanceMedicament is found, this method returns null.
     */
    @Query("select e from OrdonnanceMedicament e where e.ordonnance.id = :ordonnanceId and e.isDeleted = :isDeleted")
    List<OrdonnanceMedicament> findByOrdonnanceId(@Param("ordonnanceId")Integer ordonnanceId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one OrdonnanceMedicament by using ordonnanceId as a search criteria.
   *
   * @param ordonnanceId
   * @return An Object OrdonnanceMedicament whose ordonnanceId is equals to the given ordonnanceId. If
   *         no OrdonnanceMedicament is found, this method returns null.
   */
  @Query("select e from OrdonnanceMedicament e where e.ordonnance.id = :ordonnanceId and e.isDeleted = :isDeleted")
  OrdonnanceMedicament findOrdonnanceMedicamentByOrdonnanceId(@Param("ordonnanceId")Integer ordonnanceId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of OrdonnanceMedicament by using ordonnanceMedicamentDto as a search criteria.
     *
     * @param request, em
     * @return A List of OrdonnanceMedicament
     * @throws DataAccessException,ParseException
     */
    public default List<OrdonnanceMedicament> getByCriteria(Request<OrdonnanceMedicamentDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from OrdonnanceMedicament e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<OrdonnanceMedicament> query = em.createQuery(req, OrdonnanceMedicament.class);
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
     * Finds count of OrdonnanceMedicament by using ordonnanceMedicamentDto as a search criteria.
     *
     * @param request, em
     * @return Number of OrdonnanceMedicament
     *
     */
    public default Long count(Request<OrdonnanceMedicamentDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from OrdonnanceMedicament e where e IS NOT NULL";
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
    default String getWhereExpression(Request<OrdonnanceMedicamentDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        OrdonnanceMedicamentDto dto = request.getData() != null ? request.getData() : new OrdonnanceMedicamentDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (OrdonnanceMedicamentDto elt : request.getDatas()) {
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
    default String generateCriteria(OrdonnanceMedicamentDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (dto.getQuantite() != null || Utilities.searchParamIsNotEmpty(dto.getQuantiteParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("quantite", dto.getQuantite(), "e.quantite", "Integer", dto.getQuantiteParam(), param, index, locale));
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
                        if (dto.getMedicamentId() != null || Utilities.searchParamIsNotEmpty(dto.getMedicamentIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("medicamentId", dto.getMedicamentId(), "e.medicament.id", "Integer", dto.getMedicamentIdParam(), param, index, locale));
            }
                        if (dto.getOrdonnanceId() != null || Utilities.searchParamIsNotEmpty(dto.getOrdonnanceIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("ordonnanceId", dto.getOrdonnanceId(), "e.ordonnance.id", "Integer", dto.getOrdonnanceIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getMedicamentLibelle()) || Utilities.searchParamIsNotEmpty(dto.getMedicamentLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("medicamentLibelle", dto.getMedicamentLibelle(), "e.medicament.libelle", "String", dto.getMedicamentLibelleParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
