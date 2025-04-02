
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
 * Repository customize : Pharmacie.
 *
 * @author Geo
 *
 */
@Repository
public interface _PharmacieRepository {
	    /**
     * Finds Pharmacie by using id as a search criteria.
     *
     * @param id
     * @return An Object Pharmacie whose id is equals to the given id. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.id = :id and e.isDeleted = :isDeleted")
    Pharmacie findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Pharmacie by using nom as a search criteria.
     *
     * @param nom
     * @return An Object Pharmacie whose nom is equals to the given nom. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.nom = :nom and e.isDeleted = :isDeleted")
    List<Pharmacie> findByNom(@Param("nom")String nom, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using adresse as a search criteria.
     *
     * @param adresse
     * @return An Object Pharmacie whose adresse is equals to the given adresse. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.adresse = :adresse and e.isDeleted = :isDeleted")
    List<Pharmacie> findByAdresse(@Param("adresse")String adresse, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using latitude as a search criteria.
     *
     * @param latitude
     * @return An Object Pharmacie whose latitude is equals to the given latitude. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.latitude = :latitude and e.isDeleted = :isDeleted")
    List<Pharmacie> findByLatitude(@Param("latitude")String latitude, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using longitude as a search criteria.
     *
     * @param longitude
     * @return An Object Pharmacie whose longitude is equals to the given longitude. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.longitude = :longitude and e.isDeleted = :isDeleted")
    List<Pharmacie> findByLongitude(@Param("longitude")String longitude, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using telephone as a search criteria.
     *
     * @param telephone
     * @return An Object Pharmacie whose telephone is equals to the given telephone. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.telephone = :telephone and e.isDeleted = :isDeleted")
    Pharmacie findByTelephone(@Param("telephone")String telephone, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using email as a search criteria.
     *
     * @param email
     * @return An Object Pharmacie whose email is equals to the given email. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.email = :email and e.isDeleted = :isDeleted")
    Pharmacie findByEmail(@Param("email")String email, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using horairesOuverture as a search criteria.
     *
     * @param horairesOuverture
     * @return An Object Pharmacie whose horairesOuverture is equals to the given horairesOuverture. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.horairesOuverture = :horairesOuverture and e.isDeleted = :isDeleted")
    List<Pharmacie> findByHorairesOuverture(@Param("horairesOuverture")String horairesOuverture, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Pharmacie whose createdAt is equals to the given createdAt. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Pharmacie> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using imagesUrl as a search criteria.
     *
     * @param imagesUrl
     * @return An Object Pharmacie whose imagesUrl is equals to the given imagesUrl. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.imagesUrl = :imagesUrl and e.isDeleted = :isDeleted")
    List<Pharmacie> findByImagesUrl(@Param("imagesUrl")String imagesUrl, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Pharmacie whose createdBy is equals to the given createdBy. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Pharmacie> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Pharmacie whose deletedAt is equals to the given deletedAt. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Pharmacie> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Pharmacie whose isDeleted is equals to the given isDeleted. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.isDeleted = :isDeleted")
    List<Pharmacie> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Pharmacie whose statusId is equals to the given statusId. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Pharmacie> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Pharmacie whose updatedAt is equals to the given updatedAt. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Pharmacie> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Pharmacie by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Pharmacie whose updatedBy is equals to the given updatedBy. If
     *         no Pharmacie is found, this method returns null.
     */
    @Query("select e from Pharmacie e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Pharmacie> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Pharmacie by using pharmacieDto as a search criteria.
     *
     * @param request, em
     * @return A List of Pharmacie
     * @throws DataAccessException,ParseException
     */
    public default List<Pharmacie> getByCriteria(Request<PharmacieDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Pharmacie e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Pharmacie> query = em.createQuery(req, Pharmacie.class);
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
     * Finds count of Pharmacie by using pharmacieDto as a search criteria.
     *
     * @param request, em
     * @return Number of Pharmacie
     *
     */
    public default Long count(Request<PharmacieDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Pharmacie e where e IS NOT NULL";
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
    default String getWhereExpression(Request<PharmacieDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        PharmacieDto dto = request.getData() != null ? request.getData() : new PharmacieDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (PharmacieDto elt : request.getDatas()) {
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
    default String generateCriteria(PharmacieDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getNom()) || Utilities.searchParamIsNotEmpty(dto.getNomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("nom", dto.getNom(), "e.nom", "String", dto.getNomParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getAdresse()) || Utilities.searchParamIsNotEmpty(dto.getAdresseParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("adresse", dto.getAdresse(), "e.adresse", "String", dto.getAdresseParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLatitude()) || Utilities.searchParamIsNotEmpty(dto.getLatitudeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("latitude", dto.getLatitude(), "e.latitude", "String", dto.getLatitudeParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLongitude()) || Utilities.searchParamIsNotEmpty(dto.getLongitudeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("longitude", dto.getLongitude(), "e.longitude", "String", dto.getLongitudeParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getTelephone()) || Utilities.searchParamIsNotEmpty(dto.getTelephoneParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("telephone", dto.getTelephone(), "e.telephone", "String", dto.getTelephoneParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getEmail()) || Utilities.searchParamIsNotEmpty(dto.getEmailParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("email", dto.getEmail(), "e.email", "String", dto.getEmailParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getHorairesOuverture()) || Utilities.searchParamIsNotEmpty(dto.getHorairesOuvertureParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("horairesOuverture", dto.getHorairesOuverture(), "e.horairesOuverture", "String", dto.getHorairesOuvertureParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCreatedAt()) || Utilities.searchParamIsNotEmpty(dto.getCreatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getImagesUrl()) || Utilities.searchParamIsNotEmpty(dto.getImagesUrlParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("imagesUrl", dto.getImagesUrl(), "e.imagesUrl", "String", dto.getImagesUrlParam(), param, index, locale));
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
