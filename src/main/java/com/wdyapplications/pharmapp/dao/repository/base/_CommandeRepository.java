
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
 * Repository customize : Commande.
 *
 * @author Geo
 *
 */
@Repository
public interface _CommandeRepository {
	    /**
     * Finds Commande by using id as a search criteria.
     *
     * @param id
     * @return An Object Commande whose id is equals to the given id. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.id = :id and e.isDeleted = :isDeleted")
    Commande findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Commande by using prixTotal as a search criteria.
     *
     * @param prixTotal
     * @return An Object Commande whose prixTotal is equals to the given prixTotal. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.prixTotal = :prixTotal and e.isDeleted = :isDeleted")
    List<Commande> findByPrixTotal(@Param("prixTotal")String prixTotal, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using modeRecuperation as a search criteria.
     *
     * @param modeRecuperation
     * @return An Object Commande whose modeRecuperation is equals to the given modeRecuperation. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.modeRecuperation = :modeRecuperation and e.isDeleted = :isDeleted")
    List<Commande> findByModeRecuperation(@Param("modeRecuperation")String modeRecuperation, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Commande whose createdAt is equals to the given createdAt. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Commande> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Commande whose createdBy is equals to the given createdBy. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Commande> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Commande whose deletedAt is equals to the given deletedAt. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Commande> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Commande whose isDeleted is equals to the given isDeleted. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.isDeleted = :isDeleted")
    List<Commande> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Commande whose statusId is equals to the given statusId. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Commande> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Commande whose updatedAt is equals to the given updatedAt. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Commande> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Commande by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Commande whose updatedBy is equals to the given updatedBy. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Commande> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Commande by using pharmacieId as a search criteria.
     *
     * @param pharmacieId
     * @return An Object Commande whose pharmacieId is equals to the given pharmacieId. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.pharmacie.id = :pharmacieId and e.isDeleted = :isDeleted")
    List<Commande> findByPharmacieId(@Param("pharmacieId")Integer pharmacieId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Commande by using pharmacieId as a search criteria.
   *
   * @param pharmacieId
   * @return An Object Commande whose pharmacieId is equals to the given pharmacieId. If
   *         no Commande is found, this method returns null.
   */
  @Query("select e from Commande e where e.pharmacie.id = :pharmacieId and e.isDeleted = :isDeleted")
  Commande findCommandeByPharmacieId(@Param("pharmacieId")Integer pharmacieId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds Commande by using assuranceId as a search criteria.
     *
     * @param assuranceId
     * @return An Object Commande whose assuranceId is equals to the given assuranceId. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.assurances.id = :assuranceId and e.isDeleted = :isDeleted")
    List<Commande> findByAssuranceId(@Param("assuranceId")Integer assuranceId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Commande by using assuranceId as a search criteria.
   *
   * @param assuranceId
   * @return An Object Commande whose assuranceId is equals to the given assuranceId. If
   *         no Commande is found, this method returns null.
   */
  @Query("select e from Commande e where e.assurances.id = :assuranceId and e.isDeleted = :isDeleted")
  Commande findCommandeByAssuranceId(@Param("assuranceId")Integer assuranceId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds Commande by using ordonnanceId as a search criteria.
     *
     * @param ordonnanceId
     * @return An Object Commande whose ordonnanceId is equals to the given ordonnanceId. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.ordonnance.id = :ordonnanceId and e.isDeleted = :isDeleted")
    List<Commande> findByOrdonnanceId(@Param("ordonnanceId")Integer ordonnanceId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Commande by using ordonnanceId as a search criteria.
   *
   * @param ordonnanceId
   * @return An Object Commande whose ordonnanceId is equals to the given ordonnanceId. If
   *         no Commande is found, this method returns null.
   */
  @Query("select e from Commande e where e.ordonnance.id = :ordonnanceId and e.isDeleted = :isDeleted")
  Commande findCommandeByOrdonnanceId(@Param("ordonnanceId")Integer ordonnanceId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds Commande by using adresseId as a search criteria.
     *
     * @param adresseId
     * @return An Object Commande whose adresseId is equals to the given adresseId. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.adresse.id = :adresseId and e.isDeleted = :isDeleted")
    List<Commande> findByAdresseId(@Param("adresseId")Integer adresseId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Commande by using adresseId as a search criteria.
   *
   * @param adresseId
   * @return An Object Commande whose adresseId is equals to the given adresseId. If
   *         no Commande is found, this method returns null.
   */
  @Query("select e from Commande e where e.adresse.id = :adresseId and e.isDeleted = :isDeleted")
  Commande findCommandeByAdresseId(@Param("adresseId")Integer adresseId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds Commande by using userId as a search criteria.
     *
     * @param userId
     * @return An Object Commande whose userId is equals to the given userId. If
     *         no Commande is found, this method returns null.
     */
    @Query("select e from Commande e where e.users.id = :userId and e.isDeleted = :isDeleted")
    List<Commande> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Commande by using userId as a search criteria.
   *
   * @param userId
   * @return An Object Commande whose userId is equals to the given userId. If
   *         no Commande is found, this method returns null.
   */
  @Query("select e from Commande e where e.users.id = :userId and e.isDeleted = :isDeleted")
  Commande findCommandeByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of Commande by using commandeDto as a search criteria.
     *
     * @param request, em
     * @return A List of Commande
     * @throws DataAccessException,ParseException
     */
    public default List<Commande> getByCriteria(Request<CommandeDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Commande e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Commande> query = em.createQuery(req, Commande.class);
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
     * Finds count of Commande by using commandeDto as a search criteria.
     *
     * @param request, em
     * @return Number of Commande
     *
     */
    public default Long count(Request<CommandeDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Commande e where e IS NOT NULL";
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
    default String getWhereExpression(Request<CommandeDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        CommandeDto dto = request.getData() != null ? request.getData() : new CommandeDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (CommandeDto elt : request.getDatas()) {
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
    default String generateCriteria(CommandeDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPrixTotal()) || Utilities.searchParamIsNotEmpty(dto.getPrixTotalParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prixTotal", dto.getPrixTotal(), "e.prixTotal", "String", dto.getPrixTotalParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getModeRecuperation()) || Utilities.searchParamIsNotEmpty(dto.getModeRecuperationParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("modeRecuperation", dto.getModeRecuperation(), "e.modeRecuperation", "String", dto.getModeRecuperationParam(), param, index, locale));
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
                        if (dto.getAssuranceId() != null || Utilities.searchParamIsNotEmpty(dto.getAssuranceIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("assuranceId", dto.getAssuranceId(), "e.assurances.id", "Integer", dto.getAssuranceIdParam(), param, index, locale));
            }
                        if (dto.getOrdonnanceId() != null || Utilities.searchParamIsNotEmpty(dto.getOrdonnanceIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("ordonnanceId", dto.getOrdonnanceId(), "e.ordonnance.id", "Integer", dto.getOrdonnanceIdParam(), param, index, locale));
            }
                        if (dto.getAdresseId() != null || Utilities.searchParamIsNotEmpty(dto.getAdresseIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("adresseId", dto.getAdresseId(), "e.adresse.id", "Integer", dto.getAdresseIdParam(), param, index, locale));
            }
                        if (dto.getUserId() != null || Utilities.searchParamIsNotEmpty(dto.getUserIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("userId", dto.getUserId(), "e.users.id", "Integer", dto.getUserIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPharmacieNom()) || Utilities.searchParamIsNotEmpty(dto.getPharmacieNomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("pharmacieNom", dto.getPharmacieNom(), "e.pharmacie.nom", "String", dto.getPharmacieNomParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getAssurancesLibelle()) || Utilities.searchParamIsNotEmpty(dto.getAssurancesLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("assurancesLibelle", dto.getAssurancesLibelle(), "e.assurances.libelle", "String", dto.getAssurancesLibelleParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getAdresseLibelle()) || Utilities.searchParamIsNotEmpty(dto.getAdresseLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("adresseLibelle", dto.getAdresseLibelle(), "e.adresse.libelle", "String", dto.getAdresseLibelleParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
