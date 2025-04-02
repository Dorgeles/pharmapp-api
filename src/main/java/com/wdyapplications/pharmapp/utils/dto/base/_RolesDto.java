
/*
 * Java dto for entity table roles 
 * Created on 2024-11-08 ( Time 00:24:09 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.base;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO customize for table "roles"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _RolesDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     libelle              ;
    protected String     commentaire          ;
	protected String     createdAt            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;
    protected Boolean    isDeleted            ;
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public SearchParam<Integer> getIdParam() {
		return idParam;
	}

	public void setIdParam(SearchParam<Integer> idParam) {
		this.idParam = idParam;
	}

	public SearchParam<String> getLibelleParam() {
		return libelleParam;
	}

	public void setLibelleParam(SearchParam<String> libelleParam) {
		this.libelleParam = libelleParam;
	}

	public SearchParam<String> getCommentaireParam() {
		return commentaireParam;
	}

	public void setCommentaireParam(SearchParam<String> commentaireParam) {
		this.commentaireParam = commentaireParam;
	}

	public SearchParam<String> getCreatedAtParam() {
		return createdAtParam;
	}

	public void setCreatedAtParam(SearchParam<String> createdAtParam) {
		this.createdAtParam = createdAtParam;
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

	public SearchParam<Boolean> getIsDeletedParam() {
		return isDeletedParam;
	}

	public void setIsDeletedParam(SearchParam<Boolean> isDeletedParam) {
		this.isDeletedParam = isDeletedParam;
	}

	public SearchParam<Integer> getStatusIdParam() {
		return statusIdParam;
	}

	public void setStatusIdParam(SearchParam<Integer> statusIdParam) {
		this.statusIdParam = statusIdParam;
	}

	public SearchParam<String> getUpdatedAtParam() {
		return updatedAtParam;
	}

	public void setUpdatedAtParam(SearchParam<String> updatedAtParam) {
		this.updatedAtParam = updatedAtParam;
	}

	public SearchParam<Integer> getUpdatedByParam() {
		return updatedByParam;
	}

	public void setUpdatedByParam(SearchParam<Integer> updatedByParam) {
		this.updatedByParam = updatedByParam;
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

	protected Integer    statusId             ;
	protected String     updatedAt            ;
    protected Integer    updatedBy            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   libelleParam          ;                     
	protected SearchParam<String>   commentaireParam      ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
