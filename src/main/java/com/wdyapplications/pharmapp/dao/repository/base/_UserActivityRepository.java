
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
 * Repository customize : UserActivity.
 *
 * @author Geo
 *
 */
@Repository
public interface _UserActivityRepository {
	    /**
     * Finds UserActivity by using id as a search criteria.
     *
     * @param id
     * @return An Object UserActivity whose id is equals to the given id. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.id = :id and e.isDeleted = :isDeleted")
    UserActivity findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserActivity by using activityType as a search criteria.
     *
     * @param serviceLibelle
     * @return An Object UserActivity whose activityType is equals to the given activityType. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.serviceLibelle = :serviceLibelle and e.isDeleted = :isDeleted")
    List<UserActivity> findByServiceLibelle(@Param("serviceLibelle")String serviceLibelle, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using remoteIp as a search criteria.
     *
     * @param remoteIp
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.remoteIp = :remoteIp and e.isDeleted = :isDeleted")
    List<UserActivity> findByRemoteIp(@Param("remoteIp")String remoteIp, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using hasError as a search criteria.
     *
     * @param hasError
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.hasError = :hasError and e.isDeleted = :isDeleted")
    List<UserActivity> findByHasError(@Param("hasError")String hasError, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using device_id as a search criteria.
     *
     * @param deviceId
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.deviceId = :deviceId and e.isDeleted = :isDeleted")
    List<UserActivity> findByDeviceId(@Param("deviceId")String deviceId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using remoteIp as a search criteria.
     *
     * @param versionNumber
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.versionNumber = :versionNumber and e.isDeleted = :isDeleted")
    List<UserActivity> findByVersionNumber(@Param("versionNumber")String versionNumber, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using remoteIp as a search criteria.
     *
     * @param uri
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.uri = :uri and e.isDeleted = :isDeleted")
    List<UserActivity> findByUri(@Param("uri")String uri, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using request as a search criteria.
     *
     * @param request
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.request = :request and e.isDeleted = :isDeleted")
    List<UserActivity> findByRequest(@Param("request")String request, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using response as a search criteria.
     *
     * @param response
     * @return An Object UserActivity whose remoteIp is equals to the given remoteIp. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.response = :response and e.isDeleted = :isDeleted")
    List<UserActivity> findByResponse(@Param("response")String response, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object UserActivity whose createdAt is equals to the given createdAt. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<UserActivity> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object UserActivity whose createdBy is equals to the given createdBy. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<UserActivity> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object UserActivity whose deletedAt is equals to the given deletedAt. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<UserActivity> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object UserActivity whose isDeleted is equals to the given isDeleted. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.isDeleted = :isDeleted")
    List<UserActivity> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object UserActivity whose statusId is equals to the given statusId. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<UserActivity> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object UserActivity whose updatedAt is equals to the given updatedAt. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<UserActivity> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserActivity by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object UserActivity whose updatedBy is equals to the given updatedBy. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<UserActivity> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserActivity by using userId as a search criteria.
     *
     * @param userId
     * @return An Object UserActivity whose userId is equals to the given userId. If
     *         no UserActivity is found, this method returns null.
     */
    @Query("select e from UserActivity e where e.users.id = :userId and e.isDeleted = :isDeleted")
    List<UserActivity> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one UserActivity by using userId as a search criteria.
   *
   * @param userId
   * @return An Object UserActivity whose userId is equals to the given userId. If
   *         no UserActivity is found, this method returns null.
   */
  @Query("select e from UserActivity e where e.users.id = :userId and e.isDeleted = :isDeleted")
  UserActivity findUserActivityByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of UserActivity by using userActivityDto as a search criteria.
     *
     * @param request, em
     * @return A List of UserActivity
     * @throws DataAccessException,ParseException
     */
    public default List<UserActivity> getByCriteria(Request<UserActivityDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from UserActivity e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<UserActivity> query = em.createQuery(req, UserActivity.class);
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
     * Finds count of UserActivity by using userActivityDto as a search criteria.
     *
     * @param request, em
     * @return Number of UserActivity
     *
     */
    public default Long count(Request<UserActivityDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from UserActivity e where e IS NOT NULL";
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
    default String getWhereExpression(Request<UserActivityDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        UserActivityDto dto = request.getData() != null ? request.getData() : new UserActivityDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (UserActivityDto elt : request.getDatas()) {
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
    default String generateCriteria(UserActivityDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getServiceLibelle()) || Utilities.searchParamIsNotEmpty(dto.getServiceLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("activityType", dto.getStatusLibelle(), "e.activityType", "String", dto.getServiceLibelleParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getRemoteIp()) || Utilities.searchParamIsNotEmpty(dto.getRemoteIpParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("remoteIp", dto.getRemoteIp(), "e.remoteIp", "String", dto.getRemoteIpParam(), param, index, locale));
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
