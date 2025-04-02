
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
 * Repository customize : UserRoles.
 *
 * @author Geo
 *
 */
@Repository
public interface _UserRolesRepository {
	    /**
     * Finds UserRoles by using id as a search criteria.
     *
     * @param id
     * @return An Object UserRoles whose id is equals to the given id. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.id = :id and e.isDeleted = :isDeleted")
    UserRoles findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserRoles by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object UserRoles whose createdAt is equals to the given createdAt. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<UserRoles> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserRoles by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object UserRoles whose createdBy is equals to the given createdBy. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<UserRoles> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserRoles by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object UserRoles whose deletedAt is equals to the given deletedAt. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<UserRoles> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserRoles by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object UserRoles whose isDeleted is equals to the given isDeleted. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.isDeleted = :isDeleted")
    List<UserRoles> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserRoles by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object UserRoles whose statusId is equals to the given statusId. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<UserRoles> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserRoles by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object UserRoles whose updatedAt is equals to the given updatedAt. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<UserRoles> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds UserRoles by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object UserRoles whose updatedBy is equals to the given updatedBy. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<UserRoles> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds UserRoles by using roleId as a search criteria.
     *
     * @param roleId
     * @return An Object UserRoles whose roleId is equals to the given roleId. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.roles.id = :roleId and e.isDeleted = :isDeleted")
    List<UserRoles> findByRoleId(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one UserRoles by using roleId as a search criteria.
   *
   * @param roleId
   * @return An Object UserRoles whose roleId is equals to the given roleId. If
   *         no UserRoles is found, this method returns null.
   */
  @Query("select e from UserRoles e where e.roles.id = :roleId and e.isDeleted = :isDeleted")
  UserRoles findUserRolesByRoleId(@Param("roleId")Integer roleId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds UserRoles by using userId as a search criteria.
     *
     * @param userId
     * @return An Object UserRoles whose userId is equals to the given userId. If
     *         no UserRoles is found, this method returns null.
     */
    @Query("select e from UserRoles e where e.users.id = :userId and e.isDeleted = :isDeleted")
    List<UserRoles> findByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one UserRoles by using userId as a search criteria.
   *
   * @param userId
   * @return An Object UserRoles whose userId is equals to the given userId. If
   *         no UserRoles is found, this method returns null.
   */
  @Query("select e from UserRoles e where e.users.id = :userId and e.isDeleted = :isDeleted")
  UserRoles findUserRolesByUserId(@Param("userId")Integer userId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of UserRoles by using userRolesDto as a search criteria.
     *
     * @param request, em
     * @return A List of UserRoles
     * @throws DataAccessException,ParseException
     */
    public default List<UserRoles> getByCriteria(Request<UserRolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from UserRoles e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<UserRoles> query = em.createQuery(req, UserRoles.class);
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
     * Finds count of UserRoles by using userRolesDto as a search criteria.
     *
     * @param request, em
     * @return Number of UserRoles
     *
     */
    public default Long count(Request<UserRolesDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from UserRoles e where e IS NOT NULL";
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
    default String getWhereExpression(Request<UserRolesDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        UserRolesDto dto = request.getData() != null ? request.getData() : new UserRolesDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (UserRolesDto elt : request.getDatas()) {
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
    default String generateCriteria(UserRolesDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
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
                        if (dto.getRoleId() != null || Utilities.searchParamIsNotEmpty(dto.getRoleIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("roleId", dto.getRoleId(), "e.roles.id", "Integer", dto.getRoleIdParam(), param, index, locale));
            }
                        if (dto.getUserId() != null || Utilities.searchParamIsNotEmpty(dto.getUserIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("userId", dto.getUserId(), "e.users.id", "Integer", dto.getUserIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getRolesLibelle()) || Utilities.searchParamIsNotEmpty(dto.getRolesLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("rolesLibelle", dto.getRolesLibelle(), "e.roles.libelle", "String", dto.getRolesLibelleParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
