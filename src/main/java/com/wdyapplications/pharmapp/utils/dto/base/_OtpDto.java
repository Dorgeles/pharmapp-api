
/*
 * Java dto for entity table otp 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.base;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO customize for table "otp"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _OtpDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     codeOtp              ;
    protected String     identifier           ;
    protected Integer    origineElementId     ;
    protected Boolean    isExpired            ;
	protected String     expireOn             ;
    protected String     token                ;
	protected String     updatedAt            ;
	protected String     deletedAt            ;


	public Boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeOtp() {
		return codeOtp;
	}

	public void setCodeOtp(String codeOtp) {
		this.codeOtp = codeOtp;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Integer getOrigineElementId() {
		return origineElementId;
	}

	public void setOrigineElementId(Integer origineElementId) {
		this.origineElementId = origineElementId;
	}

	public Boolean getExpired() {
		return isExpired;
	}

	public void setExpired(Boolean expired) {
		isExpired = expired;
	}

	public String getExpireOn() {
		return expireOn;
	}

	public void setExpireOn(String expireOn) {
		this.expireOn = expireOn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public SearchParam<Integer> getIdParam() {
		return idParam;
	}

	public void setIdParam(SearchParam<Integer> idParam) {
		this.idParam = idParam;
	}

	public SearchParam<String> getCodeOtpParam() {
		return codeOtpParam;
	}

	public void setCodeOtpParam(SearchParam<String> codeOtpParam) {
		this.codeOtpParam = codeOtpParam;
	}

	public SearchParam<String> getIdentifierParam() {
		return identifierParam;
	}

	public void setIdentifierParam(SearchParam<String> identifierParam) {
		this.identifierParam = identifierParam;
	}

	public SearchParam<Integer> getOrigineElementIdParam() {
		return origineElementIdParam;
	}

	public void setOrigineElementIdParam(SearchParam<Integer> origineElementIdParam) {
		this.origineElementIdParam = origineElementIdParam;
	}

	public SearchParam<Boolean> getIsExpiredParam() {
		return isExpiredParam;
	}

	public void setIsExpiredParam(SearchParam<Boolean> isExpiredParam) {
		this.isExpiredParam = isExpiredParam;
	}

	public SearchParam<String> getExpireOnParam() {
		return expireOnParam;
	}

	public void setExpireOnParam(SearchParam<String> expireOnParam) {
		this.expireOnParam = expireOnParam;
	}

	public SearchParam<String> getTokenParam() {
		return tokenParam;
	}

	public void setTokenParam(SearchParam<String> tokenParam) {
		this.tokenParam = tokenParam;
	}

	public SearchParam<String> getUpdatedAtParam() {
		return updatedAtParam;
	}

	public void setUpdatedAtParam(SearchParam<String> updatedAtParam) {
		this.updatedAtParam = updatedAtParam;
	}

	public SearchParam<String> getDeletedAtParam() {
		return deletedAtParam;
	}

	public void setDeletedAtParam(SearchParam<String> deletedAtParam) {
		this.deletedAtParam = deletedAtParam;
	}

	public SearchParam<Integer> getCreatedByParam() {
		return createdByParam;
	}

	public void setCreatedByParam(SearchParam<Integer> createdByParam) {
		this.createdByParam = createdByParam;
	}

	public SearchParam<Integer> getUpdatedByParam() {
		return updatedByParam;
	}

	public void setUpdatedByParam(SearchParam<Integer> updatedByParam) {
		this.updatedByParam = updatedByParam;
	}

	public SearchParam<Boolean> getIsDeletedParam() {
		return isDeletedParam;
	}

	public void setIsDeletedParam(SearchParam<Boolean> isDeletedParam) {
		this.isDeletedParam = isDeletedParam;
	}

	public SearchParam<String> getCommentaireParam() {
		return commentaireParam;
	}

	public void setCommentaireParam(SearchParam<String> commentaireParam) {
		this.commentaireParam = commentaireParam;
	}

	public SearchParam<Integer> getStatusIdParam() {
		return statusIdParam;
	}

	public void setStatusIdParam(SearchParam<Integer> statusIdParam) {
		this.statusIdParam = statusIdParam;
	}

	public SearchParam<String> getCreatedAtParam() {
		return createdAtParam;
	}

	public void setCreatedAtParam(SearchParam<String> createdAtParam) {
		this.createdAtParam = createdAtParam;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	protected Integer    createdBy            ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
    protected String     commentaire          ;
    protected Integer    statusId             ;
	protected String     createdAt            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   codeOtpParam          ;                     
	protected SearchParam<String>   identifierParam       ;                     
	protected SearchParam<Integer>  origineElementIdParam ;                     
	protected SearchParam<Boolean>  isExpiredParam        ;                     
	protected SearchParam<String>   expireOnParam         ;                     
	protected SearchParam<String>   tokenParam            ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<String>   commentaireParam      ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<String>   createdAtParam        ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
