
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
 * Repository customize : UserPreferences.
 *
 * @author Geo
 *
 */
@Repository
public interface _UserPreferencesRepository {
	    /**
     * Finds UserPreferences by using id as a search criteria.
     *
     * @param id
     * @return An Object UserPreferences whose id is equals to the given id. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.id = :id and e.isDeleted = :isDeleted")
    UserPreferences findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserPreferences by using preferenceKey as a search criteria.
     *
     * @param preferenceKey
     * @return An Object UserPreferences whose preferenceKey is equals to the given preferenceKey. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.preferenceKey = :preferenceKey and e.isDeleted = :isDeleted")
    List<UserPreferences> findByPreferenceKey(@Param("preferenceKey")String preferenceKey, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using preferenceValue as a search criteria.
     *
     * @param preferenceValue
     * @return An Object UserPreferences whose preferenceValue is equals to the given preferenceValue. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.preferenceValue = :preferenceValue and e.isDeleted = :isDeleted")
    List<UserPreferences> findByPreferenceValue(@Param("preferenceValue")String preferenceValue, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object UserPreferences whose createdAt is equals to the given createdAt. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<UserPreferences> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object UserPreferences whose createdBy is equals to the given createdBy. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<UserPreferences> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object UserPreferences whose deletedAt is equals to the given deletedAt. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<UserPreferences> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object UserPreferences whose isDeleted is equals to the given isDeleted. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.isDeleted = :isDeleted")
    List<UserPreferences> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object UserPreferences whose statusId is equals to the given statusId. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<UserPreferences> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object UserPreferences whose updatedAt is equals to the given updatedAt. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<UserPreferences> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserPreferences by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object UserPreferences whose updatedBy is equals to the given updatedBy. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<UserPreferences> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserPreferences by using userId as a search criteria.
     *
     * @param userId
     * @return An Object UserPreferences whose userId is equals to the given userId. If
     *         no UserPreferences is found, this method returns null.
     */
    @Query("select e from UserPreferences e where e.users.id = :userId and e.isDeleted = :isDeleted")
    List<UserPreferences> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one UserPreferences by using userId as a search criteria.
   *
   * @param userId
   * @return An Object UserPreferences whose userId is equals to the given userId. If
   *         no UserPreferences is found, this method returns null.
   */
  @Query("select e from UserPreferences e where e.users.id = :userId and e.isDeleted = :isDeleted")
  UserPreferences findUserPreferencesByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of UserPreferences by using userPreferencesDto as a search criteria.
     *
     * @param request, em
     * @return A List of UserPreferences
     * @throws DataAccessException,ParseException
     */
    public default List<UserPreferences> getByCriteria(Request<UserPreferencesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from UserPreferences e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<UserPreferences> query = em.createQuery(req, UserPreferences.class);
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
     * Finds count of UserPreferences by using userPreferencesDto as a search criteria.
     *
     * @param request, em
     * @return Number of UserPreferences
     *
     */
    public default Long count(Request<UserPreferencesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from UserPreferences e where e IS NOT NULL";
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
    default String getWhereExpression(Request<UserPreferencesDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        UserPreferencesDto dto = request.getData() != null ? request.getData() : new UserPreferencesDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (UserPreferencesDto elt : request.getDatas()) {
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
    default String generateCriteria(UserPreferencesDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPreferenceKey()) || Utilities.searchParamIsNotEmpty(dto.getPreferenceKeyParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("preferenceKey", dto.getPreferenceKey(), "e.preferenceKey", "String", dto.getPreferenceKeyParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPreferenceValue()) || Utilities.searchParamIsNotEmpty(dto.getPreferenceValueParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("preferenceValue", dto.getPreferenceValue(), "e.preferenceValue", "String", dto.getPreferenceValueParam(), param, index, locale));
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
                        if (dto.getUserId() != null || Utilities.searchParamIsNotEmpty(dto.getUserIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("userId", dto.getUserId(), "e.users.id", "Integer", dto.getUserIdParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
