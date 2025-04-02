
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
 * Repository customize : Otp.
 *
 * @author Geo
 *
 */
@Repository
public interface _OtpRepository {
	    /**
     * Finds Otp by using id as a search criteria.
     *
     * @param id
     * @return An Object Otp whose id is equals to the given id. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.id = :id and e.isDeleted = :isDeleted")
    Otp findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Otp by using codeOtp as a search criteria.
     *
     * @param codeOtp
     * @return An Object Otp whose codeOtp is equals to the given codeOtp. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.codeOtp = :codeOtp and e.isDeleted = :isDeleted")
    List<Otp> findByCodeOtp(@Param("codeOtp")String codeOtp, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using identifier as a search criteria.
     *
     * @param identifier
     * @return An Object Otp whose identifier is equals to the given identifier. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.identifier = :identifier and e.isDeleted = :isDeleted")
    List<Otp> findByIdentifier(@Param("identifier")String identifier, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using origineElementId as a search criteria.
     *
     * @param origineElementId
     * @return An Object Otp whose origineElementId is equals to the given origineElementId. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.origineElementId = :origineElementId and e.isDeleted = :isDeleted")
    List<Otp> findByOrigineElementId(@Param("origineElementId")Integer origineElementId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using isExpired as a search criteria.
     *
     * @param isExpired
     * @return An Object Otp whose isExpired is equals to the given isExpired. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.isExpired = :isExpired and e.isDeleted = :isDeleted")
    List<Otp> findByIsExpired(@Param("isExpired")Boolean isExpired, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using expireOn as a search criteria.
     *
     * @param expireOn
     * @return An Object Otp whose expireOn is equals to the given expireOn. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.expireOn = :expireOn and e.isDeleted = :isDeleted")
    List<Otp> findByExpireOn(@Param("expireOn")Date expireOn, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using token as a search criteria.
     *
     * @param token
     * @return An Object Otp whose token is equals to the given token. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.token = :token and e.isDeleted = :isDeleted")
    List<Otp> findByToken(@Param("token")String token, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Otp whose updatedAt is equals to the given updatedAt. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Otp> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Otp whose deletedAt is equals to the given deletedAt. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Otp> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Otp whose createdBy is equals to the given createdBy. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Otp> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Otp whose updatedBy is equals to the given updatedBy. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Otp> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Otp whose isDeleted is equals to the given isDeleted. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.isDeleted = :isDeleted")
    List<Otp> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using commentaire as a search criteria.
     *
     * @param commentaire
     * @return An Object Otp whose commentaire is equals to the given commentaire. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.commentaire = :commentaire and e.isDeleted = :isDeleted")
    List<Otp> findByCommentaire(@Param("commentaire")String commentaire, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Otp whose statusId is equals to the given statusId. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Otp> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Otp by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Otp whose createdAt is equals to the given createdAt. If
     *         no Otp is found, this method returns null.
     */
    @Query("select e from Otp e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Otp> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Otp by using otpDto as a search criteria.
     *
     * @param request, em
     * @return A List of Otp
     * @throws DataAccessException,ParseException
     */
    public default List<Otp> getByCriteria(Request<OtpDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Otp e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Otp> query = em.createQuery(req, Otp.class);
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
     * Finds count of Otp by using otpDto as a search criteria.
     *
     * @param request, em
     * @return Number of Otp
     *
     */
    public default Long count(Request<OtpDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Otp e where e IS NOT NULL";
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
    default String getWhereExpression(Request<OtpDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        OtpDto dto = request.getData() != null ? request.getData() : new OtpDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (OtpDto elt : request.getDatas()) {
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
    default String generateCriteria(OtpDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCodeOtp()) || Utilities.searchParamIsNotEmpty(dto.getCodeOtpParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("codeOtp", dto.getCodeOtp(), "e.codeOtp", "String", dto.getCodeOtpParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getIdentifier()) || Utilities.searchParamIsNotEmpty(dto.getIdentifierParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("identifier", dto.getIdentifier(), "e.identifier", "String", dto.getIdentifierParam(), param, index, locale));
            }
            if (dto.getOrigineElementId() != null || Utilities.searchParamIsNotEmpty(dto.getOrigineElementIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("origineElementId", dto.getOrigineElementId(), "e.origineElementId", "Integer", dto.getOrigineElementIdParam(), param, index, locale));
            }
            if (dto.getIsExpired() != null || Utilities.searchParamIsNotEmpty(dto.getIsExpiredParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("isExpired", dto.getIsExpired(), "e.isExpired", "Boolean", dto.getIsExpiredParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getExpireOn()) || Utilities.searchParamIsNotEmpty(dto.getExpireOnParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("expireOn", dto.getExpireOn(), "e.expireOn", "Date", dto.getExpireOnParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getToken()) || Utilities.searchParamIsNotEmpty(dto.getTokenParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("token", dto.getToken(), "e.token", "String", dto.getTokenParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUpdatedAt()) || Utilities.searchParamIsNotEmpty(dto.getUpdatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDeletedAt()) || Utilities.searchParamIsNotEmpty(dto.getDeletedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("deletedAt", dto.getDeletedAt(), "e.deletedAt", "Date", dto.getDeletedAtParam(), param, index, locale));
            }
            if (dto.getCreatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getCreatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdBy", dto.getCreatedBy(), "e.createdBy", "Integer", dto.getCreatedByParam(), param, index, locale));
            }
            if (dto.getUpdatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getUpdatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedBy", dto.getUpdatedBy(), "e.updatedBy", "Integer", dto.getUpdatedByParam(), param, index, locale));
            }
            if (dto.getIsDeleted() != null || Utilities.searchParamIsNotEmpty(dto.getIsDeletedParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("isDeleted", dto.getIsDeleted(), "e.isDeleted", "Boolean", dto.getIsDeletedParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCommentaire()) || Utilities.searchParamIsNotEmpty(dto.getCommentaireParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("commentaire", dto.getCommentaire(), "e.commentaire", "String", dto.getCommentaireParam(), param, index, locale));
            }
            if (dto.getStatusId() != null || Utilities.searchParamIsNotEmpty(dto.getStatusIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("statusId", dto.getStatusId(), "e.statusId", "Integer", dto.getStatusIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCreatedAt()) || Utilities.searchParamIsNotEmpty(dto.getCreatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
