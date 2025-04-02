
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
 * Repository customize : UserProfile.
 *
 * @author Geo
 *
 */
@Repository
public interface _UserProfileRepository {
	    /**
     * Finds UserProfile by using id as a search criteria.
     *
     * @param id
     * @return An Object UserProfile whose id is equals to the given id. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.id = :id and e.isDeleted = :isDeleted")
    UserProfile findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserProfile by using firstname as a search criteria.
     *
     * @param firstname
     * @return An Object UserProfile whose firstname is equals to the given firstname. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.firstname = :firstname and e.isDeleted = :isDeleted")
    List<UserProfile> findByFirstname(@Param("firstname")String firstname, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using lastname as a search criteria.
     *
     * @param lastname
     * @return An Object UserProfile whose lastname is equals to the given lastname. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.lastname = :lastname and e.isDeleted = :isDeleted")
    List<UserProfile> findByLastname(@Param("lastname")String lastname, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using profilePicture as a search criteria.
     *
     * @param profilePicture
     * @return An Object UserProfile whose profilePicture is equals to the given profilePicture. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.profilePicture = :profilePicture and e.isDeleted = :isDeleted")
    List<UserProfile> findByProfilePicture(@Param("profilePicture")String profilePicture, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using contact as a search criteria.
     *
     * @param contact
     * @return An Object UserProfile whose contact is equals to the given contact. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.contact = :contact and e.isDeleted = :isDeleted")
    List<UserProfile> findByContact(@Param("contact")String contact, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object UserProfile whose createdAt is equals to the given createdAt. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<UserProfile> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object UserProfile whose createdBy is equals to the given createdBy. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<UserProfile> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object UserProfile whose deletedAt is equals to the given deletedAt. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<UserProfile> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object UserProfile whose isDeleted is equals to the given isDeleted. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.isDeleted = :isDeleted")
    List<UserProfile> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object UserProfile whose statusId is equals to the given statusId. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<UserProfile> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object UserProfile whose updatedAt is equals to the given updatedAt. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<UserProfile> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserProfile by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object UserProfile whose updatedBy is equals to the given updatedBy. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<UserProfile> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserProfile by using userId as a search criteria.
     *
     * @param userId
     * @return An Object UserProfile whose userId is equals to the given userId. If
     *         no UserProfile is found, this method returns null.
     */
    @Query("select e from UserProfile e where e.users.id = :userId and e.isDeleted = :isDeleted")
    List<UserProfile> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one UserProfile by using userId as a search criteria.
   *
   * @param userId
   * @return An Object UserProfile whose userId is equals to the given userId. If
   *         no UserProfile is found, this method returns null.
   */
  @Query("select e from UserProfile e where e.users.id = :userId and e.isDeleted = :isDeleted")
  UserProfile findUserProfileByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of UserProfile by using userProfileDto as a search criteria.
     *
     * @param request, em
     * @return A List of UserProfile
     * @throws DataAccessException,ParseException
     */
    public default List<UserProfile> getByCriteria(Request<UserProfileDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from UserProfile e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<UserProfile> query = em.createQuery(req, UserProfile.class);
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
     * Finds count of UserProfile by using userProfileDto as a search criteria.
     *
     * @param request, em
     * @return Number of UserProfile
     *
     */
    public default Long count(Request<UserProfileDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from UserProfile e where e IS NOT NULL";
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
    default String getWhereExpression(Request<UserProfileDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        UserProfileDto dto = request.getData() != null ? request.getData() : new UserProfileDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (UserProfileDto elt : request.getDatas()) {
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
    default String generateCriteria(UserProfileDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getFirstname()) || Utilities.searchParamIsNotEmpty(dto.getFirstnameParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("firstname", dto.getFirstname(), "e.firstname", "String", dto.getFirstnameParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLastname()) || Utilities.searchParamIsNotEmpty(dto.getLastnameParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("lastname", dto.getLastname(), "e.lastname", "String", dto.getLastnameParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getProfilePicture()) || Utilities.searchParamIsNotEmpty(dto.getProfilePictureParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("profilePicture", dto.getProfilePicture(), "e.profilePicture", "String", dto.getProfilePictureParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getContact()) || Utilities.searchParamIsNotEmpty(dto.getContactParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("contact", dto.getContact(), "e.contact", "String", dto.getContactParam(), param, index, locale));
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
