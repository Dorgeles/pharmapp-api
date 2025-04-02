
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
 * Repository customize : PrixMedicament.
 *
 * @author Geo
 *
 */
@Repository
public interface _PrixMedicamentRepository {
	    /**
     * Finds PrixMedicament by using id as a search criteria.
     *
     * @param id
     * @return An Object PrixMedicament whose id is equals to the given id. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.id = :id and e.isDeleted = :isDeleted")
    PrixMedicament findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds PrixMedicament by using prixUnitaire as a search criteria.
     *
     * @param prixUnitaire
     * @return An Object PrixMedicament whose prixUnitaire is equals to the given prixUnitaire. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.prixUnitaire = :prixUnitaire and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByPrixUnitaire(@Param("prixUnitaire")String prixUnitaire, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object PrixMedicament whose createdAt is equals to the given createdAt. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object PrixMedicament whose createdBy is equals to the given createdBy. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object PrixMedicament whose deletedAt is equals to the given deletedAt. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object PrixMedicament whose isDeleted is equals to the given isDeleted. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.isDeleted = :isDeleted")
    List<PrixMedicament> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object PrixMedicament whose statusId is equals to the given statusId. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object PrixMedicament whose updatedAt is equals to the given updatedAt. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrixMedicament by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object PrixMedicament whose updatedBy is equals to the given updatedBy. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds PrixMedicament by using pharmacieId as a search criteria.
     *
     * @param pharmacieId
     * @return An Object PrixMedicament whose pharmacieId is equals to the given pharmacieId. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.pharmacie.id = :pharmacieId and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByPharmacieId(@Param("pharmacieId")Integer pharmacieId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one PrixMedicament by using pharmacieId as a search criteria.
   *
   * @param pharmacieId
   * @return An Object PrixMedicament whose pharmacieId is equals to the given pharmacieId. If
   *         no PrixMedicament is found, this method returns null.
   */
  @Query("select e from PrixMedicament e where e.pharmacie.id = :pharmacieId and e.isDeleted = :isDeleted")
  PrixMedicament findPrixMedicamentByPharmacieId(@Param("pharmacieId")Integer pharmacieId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds PrixMedicament by using medicamentId as a search criteria.
     *
     * @param medicamentId
     * @return An Object PrixMedicament whose medicamentId is equals to the given medicamentId. If
     *         no PrixMedicament is found, this method returns null.
     */
    @Query("select e from PrixMedicament e where e.medicament.id = :medicamentId and e.isDeleted = :isDeleted")
    List<PrixMedicament> findByMedicamentId(@Param("medicamentId")Integer medicamentId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one PrixMedicament by using medicamentId as a search criteria.
   *
   * @param medicamentId
   * @return An Object PrixMedicament whose medicamentId is equals to the given medicamentId. If
   *         no PrixMedicament is found, this method returns null.
   */
  @Query("select e from PrixMedicament e where e.medicament.id = :medicamentId and e.isDeleted = :isDeleted")
  PrixMedicament findPrixMedicamentByMedicamentId(@Param("medicamentId")Integer medicamentId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of PrixMedicament by using prixMedicamentDto as a search criteria.
     *
     * @param request, em
     * @return A List of PrixMedicament
     * @throws DataAccessException,ParseException
     */
    public default List<PrixMedicament> getByCriteria(Request<PrixMedicamentDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from PrixMedicament e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<PrixMedicament> query = em.createQuery(req, PrixMedicament.class);
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
     * Finds count of PrixMedicament by using prixMedicamentDto as a search criteria.
     *
     * @param request, em
     * @return Number of PrixMedicament
     *
     */
    public default Long count(Request<PrixMedicamentDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from PrixMedicament e where e IS NOT NULL";
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
    default String getWhereExpression(Request<PrixMedicamentDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        PrixMedicamentDto dto = request.getData() != null ? request.getData() : new PrixMedicamentDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (PrixMedicamentDto elt : request.getDatas()) {
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
    default String generateCriteria(PrixMedicamentDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPrixUnitaire()) || Utilities.searchParamIsNotEmpty(dto.getPrixUnitaireParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prixUnitaire", dto.getPrixUnitaire(), "e.prixUnitaire", "String", dto.getPrixUnitaireParam(), param, index, locale));
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
                        if (dto.getPharmacieId() != null || Utilities.searchParamIsNotEmpty(dto.getPharmacieIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("pharmacieId", dto.getPharmacieId(), "e.pharmacie.id", "Integer", dto.getPharmacieIdParam(), param, index, locale));
            }
                        if (dto.getMedicamentId() != null || Utilities.searchParamIsNotEmpty(dto.getMedicamentIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("medicamentId", dto.getMedicamentId(), "e.medicament.id", "Integer", dto.getMedicamentIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPharmacieNom()) || Utilities.searchParamIsNotEmpty(dto.getPharmacieNomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("pharmacieNom", dto.getPharmacieNom(), "e.pharmacie.nom", "String", dto.getPharmacieNomParam(), param, index, locale));
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
