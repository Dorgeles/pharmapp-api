
/*
 * Java dto for entity table setting 
 * Created on 2024-11-16 ( Time 14:29:24 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.base;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO customize for table "setting"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _SettingDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     code                 ;
    protected String     valeur               ;
    protected Integer    statusId             ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
    protected Integer    createdBy            ;
	protected String     deletedAt            ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
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

	public SearchParam<String> getCodeParam() {
		return codeParam;
	}

	public void setCodeParam(SearchParam<String> codeParam) {
		this.codeParam = codeParam;
	}

	public SearchParam<String> getValeurParam() {
		return valeurParam;
	}

	public void setValeurParam(SearchParam<String> valeurParam) {
		this.valeurParam = valeurParam;
	}

	public SearchParam<Integer> getStatusIdParam() {
		return statusIdParam;
	}

	public void setStatusIdParam(SearchParam<Integer> statusIdParam) {
		this.statusIdParam = statusIdParam;
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

	public SearchParam<Integer> getCreatedByParam() {
		return createdByParam;
	}

	public void setCreatedByParam(SearchParam<Integer> createdByParam) {
		this.createdByParam = createdByParam;
	}

	public SearchParam<String> getDeletedAtParam() {
		return deletedAtParam;
	}

	public void setDeletedAtParam(SearchParam<String> deletedAtParam) {
		this.deletedAtParam = deletedAtParam;
	}

	public SearchParam<String> getUpdatedAtParam() {
		return updatedAtParam;
	}

	public void setUpdatedAtParam(SearchParam<String> updatedAtParam) {
		this.updatedAtParam = updatedAtParam;
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

	protected String     updatedAt            ;
	protected String     createdAt            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   codeParam             ;                     
	protected SearchParam<String>   valeurParam           ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
