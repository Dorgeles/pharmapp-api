
/*
 * Java dto for entity table ordonnance_medicament 
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
 * DTO customize for table "ordonnance_medicament"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _OrdonnanceMedicamentDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    ordonnanceId         ;
    protected Integer    medicamentId         ;
    protected Integer    quantite             ;
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

	public Integer getOrdonnanceId() {
		return ordonnanceId;
	}

	public void setOrdonnanceId(Integer ordonnanceId) {
		this.ordonnanceId = ordonnanceId;
	}

	public Integer getMedicamentId() {
		return medicamentId;
	}

	public void setMedicamentId(Integer medicamentId) {
		this.medicamentId = medicamentId;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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

	public String getMedicamentLibelle() {
		return medicamentLibelle;
	}

	public void setMedicamentLibelle(String medicamentLibelle) {
		this.medicamentLibelle = medicamentLibelle;
	}

	public SearchParam<Integer> getIdParam() {
		return idParam;
	}

	public void setIdParam(SearchParam<Integer> idParam) {
		this.idParam = idParam;
	}

	public SearchParam<Integer> getOrdonnanceIdParam() {
		return ordonnanceIdParam;
	}

	public void setOrdonnanceIdParam(SearchParam<Integer> ordonnanceIdParam) {
		this.ordonnanceIdParam = ordonnanceIdParam;
	}

	public SearchParam<Integer> getMedicamentIdParam() {
		return medicamentIdParam;
	}

	public void setMedicamentIdParam(SearchParam<Integer> medicamentIdParam) {
		this.medicamentIdParam = medicamentIdParam;
	}

	public SearchParam<Integer> getQuantiteParam() {
		return quantiteParam;
	}

	public void setQuantiteParam(SearchParam<Integer> quantiteParam) {
		this.quantiteParam = quantiteParam;
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

	public SearchParam<Integer> getMedicamentParam() {
		return medicamentParam;
	}

	public void setMedicamentParam(SearchParam<Integer> medicamentParam) {
		this.medicamentParam = medicamentParam;
	}

	public SearchParam<String> getMedicamentLibelleParam() {
		return medicamentLibelleParam;
	}

	public void setMedicamentLibelleParam(SearchParam<String> medicamentLibelleParam) {
		this.medicamentLibelleParam = medicamentLibelleParam;
	}

	public SearchParam<Integer> getOrdonnanceParam() {
		return ordonnanceParam;
	}

	public void setOrdonnanceParam(SearchParam<Integer> ordonnanceParam) {
		this.ordonnanceParam = ordonnanceParam;
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
	//protected Integer    medicament;
	protected String medicamentLibelle;
	//protected Integer    ordonnance;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  ordonnanceIdParam     ;                     
	protected SearchParam<Integer>  medicamentIdParam     ;                     
	protected SearchParam<Integer>  quantiteParam         ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Integer>  medicamentParam       ;                     
	protected SearchParam<String>   medicamentLibelleParam;                     
	protected SearchParam<Integer>  ordonnanceParam       ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
