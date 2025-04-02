
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
 * Repository customize : Users.
 *
 * @author Geo
 *
 */
@Repository
public interface _UsersRepository {
	    /**
     * Finds Users by using id as a search criteria.
     *
     * @param id
     * @return An Object Users whose id is equals to the given id. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.id = :id and e.isDeleted = :isDeleted")
    Users findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Users by using username as a search criteria.
     *
     * @param username
     * @return An Object Users whose username is equals to the given username. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.username = :username and e.isDeleted = :isDeleted")
    List<Users> findByUsername(@Param("username")String username, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using password as a search criteria.
     *
     * @param password
     * @return An Object Users whose password is equals to the given password. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.password = :password and e.isDeleted = :isDeleted")
    List<Users> findByPassword(@Param("password")String password, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using email as a search criteria.
     *
     * @param email
     * @return An Object Users whose email is equals to the given email. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.email = :email and e.isDeleted = :isDeleted")
    Users findByEmail(@Param("email")String email, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Users whose createdAt is equals to the given createdAt. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Users> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Users whose createdBy is equals to the given createdBy. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Users> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Users whose deletedAt is equals to the given deletedAt. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Users> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Users whose isDeleted is equals to the given isDeleted. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.isDeleted = :isDeleted")
    List<Users> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Users whose statusId is equals to the given statusId. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Users> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Users whose updatedAt is equals to the given updatedAt. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Users> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Users by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Users whose updatedBy is equals to the given updatedBy. If
     *         no Users is found, this method returns null.
     */
    @Query("select e from Users e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Users> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Users by using usersDto as a search criteria.
     *
     * @param request, em
     * @return A List of Users
     * @throws DataAccessException,ParseException
     */
    public default List<Users> getByCriteria(Request<UsersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Users e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Users> query = em.createQuery(req, Users.class);
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
     * Finds count of Users by using usersDto as a search criteria.
     *
     * @param request, em
     * @return Number of Users
     *
     */
    public default Long count(Request<UsersDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Users e where e IS NOT NULL";
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
    default String getWhereExpression(Request<UsersDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        UsersDto dto = request.getData() != null ? request.getData() : new UsersDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (UsersDto elt : request.getDatas()) {
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
    default String generateCriteria(UsersDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUsername()) || Utilities.searchParamIsNotEmpty(dto.getUsernameParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("username", dto.getUsername(), "e.username", "String", dto.getUsernameParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPassword()) || Utilities.searchParamIsNotEmpty(dto.getPasswordParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("password", dto.getPassword(), "e.password", "String", dto.getPasswordParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getEmail()) || Utilities.searchParamIsNotEmpty(dto.getEmailParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("email", dto.getEmail(), "e.email", "String", dto.getEmailParam(), param, index, locale));
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
