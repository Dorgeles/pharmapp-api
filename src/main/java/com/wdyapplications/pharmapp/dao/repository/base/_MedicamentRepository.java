
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
 * Repository customize : Medicament.
 *
 * @author Geo
 *
 */
@Repository
public interface _MedicamentRepository {
	    /**
     * Finds Medicament by using id as a search criteria.
     *
     * @param id
     * @return An Object Medicament whose id is equals to the given id. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.id = :id and e.isDeleted = :isDeleted")
    Medicament findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Medicament by using libelle as a search criteria.
     *
     * @param libelle
     * @return An Object Medicament whose libelle is equals to the given libelle. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.libelle = :libelle and e.isDeleted = :isDeleted")
    Medicament findByLibelle(@Param("libelle")String libelle, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using dosage as a search criteria.
     *
     * @param dosage
     * @return An Object Medicament whose dosage is equals to the given dosage. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.dosage = :dosage and e.isDeleted = :isDeleted")
    List<Medicament> findByDosage(@Param("dosage")String dosage, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using formePharmaceutique as a search criteria.
     *
     * @param formePharmaceutique
     * @return An Object Medicament whose formePharmaceutique is equals to the given formePharmaceutique. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.formePharmaceutique = :formePharmaceutique and e.isDeleted = :isDeleted")
    List<Medicament> findByFormePharmaceutique(@Param("formePharmaceutique")String formePharmaceutique, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using plafondPrix as a search criteria.
     *
     * @param plafondPrix
     * @return An Object Medicament whose plafondPrix is equals to the given plafondPrix. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.plafondPrix = :plafondPrix and e.isDeleted = :isDeleted")
    List<Medicament> findByPlafondPrix(@Param("plafondPrix")String plafondPrix, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using principeActif as a search criteria.
     *
     * @param principeActif
     * @return An Object Medicament whose principeActif is equals to the given principeActif. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.principeActif = :principeActif and e.isDeleted = :isDeleted")
    List<Medicament> findByPrincipeActif(@Param("principeActif")String principeActif, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using laboratoire as a search criteria.
     *
     * @param laboratoire
     * @return An Object Medicament whose laboratoire is equals to the given laboratoire. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.laboratoire = :laboratoire and e.isDeleted = :isDeleted")
    List<Medicament> findByLaboratoire(@Param("laboratoire")String laboratoire, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using description as a search criteria.
     *
     * @param description
     * @return An Object Medicament whose description is equals to the given description. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.description = :description and e.isDeleted = :isDeleted")
    List<Medicament> findByDescription(@Param("description")String description, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Medicament whose createdAt is equals to the given createdAt. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Medicament> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Medicament whose createdBy is equals to the given createdBy. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Medicament> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Medicament whose deletedAt is equals to the given deletedAt. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Medicament> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Medicament whose isDeleted is equals to the given isDeleted. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.isDeleted = :isDeleted")
    List<Medicament> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Medicament whose statusId is equals to the given statusId. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Medicament> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Medicament whose updatedAt is equals to the given updatedAt. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Medicament> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Medicament by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Medicament whose updatedBy is equals to the given updatedBy. If
     *         no Medicament is found, this method returns null.
     */
    @Query("select e from Medicament e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Medicament> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Medicament by using medicamentDto as a search criteria.
     *
     * @param request, em
     * @return A List of Medicament
     * @throws DataAccessException,ParseException
     */
    public default List<Medicament> getByCriteria(Request<MedicamentDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Medicament e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Medicament> query = em.createQuery(req, Medicament.class);
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
     * Finds count of Medicament by using medicamentDto as a search criteria.
     *
     * @param request, em
     * @return Number of Medicament
     *
     */
    public default Long count(Request<MedicamentDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Medicament e where e IS NOT NULL";
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
    default String getWhereExpression(Request<MedicamentDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        MedicamentDto dto = request.getData() != null ? request.getData() : new MedicamentDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (MedicamentDto elt : request.getDatas()) {
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
    default String generateCriteria(MedicamentDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLibelle()) || Utilities.searchParamIsNotEmpty(dto.getLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("libelle", dto.getLibelle(), "e.libelle", "String", dto.getLibelleParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDosage()) || Utilities.searchParamIsNotEmpty(dto.getDosageParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dosage", dto.getDosage(), "e.dosage", "String", dto.getDosageParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getFormePharmaceutique()) || Utilities.searchParamIsNotEmpty(dto.getFormePharmaceutiqueParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("formePharmaceutique", dto.getFormePharmaceutique(), "e.formePharmaceutique", "String", dto.getFormePharmaceutiqueParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPlafondPrix()) || Utilities.searchParamIsNotEmpty(dto.getPlafondPrixParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("plafondPrix", dto.getPlafondPrix(), "e.plafondPrix", "String", dto.getPlafondPrixParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPrincipeActif()) || Utilities.searchParamIsNotEmpty(dto.getPrincipeActifParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("principeActif", dto.getPrincipeActif(), "e.principeActif", "String", dto.getPrincipeActifParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLaboratoire()) || Utilities.searchParamIsNotEmpty(dto.getLaboratoireParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("laboratoire", dto.getLaboratoire(), "e.laboratoire", "String", dto.getLaboratoireParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDescription()) || Utilities.searchParamIsNotEmpty(dto.getDescriptionParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("description", dto.getDescription(), "e.description", "String", dto.getDescriptionParam(), param, index, locale));
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
