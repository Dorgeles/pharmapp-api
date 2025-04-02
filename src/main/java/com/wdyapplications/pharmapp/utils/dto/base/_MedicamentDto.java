
/*
 * Java dto for entity table medicament 
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
 * DTO customize for table "medicament"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _MedicamentDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     libelle              ;
    protected String     dosage               ;
    protected String     formePharmaceutique  ;
    protected String     plafondPrix          ;
    protected String     principeActif        ;
    protected String     laboratoire          ;
    protected String     description          ;

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

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFormePharmaceutique() {
		return formePharmaceutique;
	}

	public void setFormePharmaceutique(String formePharmaceutique) {
		this.formePharmaceutique = formePharmaceutique;
	}

	public String getPlafondPrix() {
		return plafondPrix;
	}

	public void setPlafondPrix(String plafondPrix) {
		this.plafondPrix = plafondPrix;
	}

	public String getPrincipeActif() {
		return principeActif;
	}

	public void setPrincipeActif(String principeActif) {
		this.principeActif = principeActif;
	}

	public String getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public SearchParam<String> getDosageParam() {
		return dosageParam;
	}

	public void setDosageParam(SearchParam<String> dosageParam) {
		this.dosageParam = dosageParam;
	}

	public SearchParam<String> getFormePharmaceutiqueParam() {
		return formePharmaceutiqueParam;
	}

	public void setFormePharmaceutiqueParam(SearchParam<String> formePharmaceutiqueParam) {
		this.formePharmaceutiqueParam = formePharmaceutiqueParam;
	}

	public SearchParam<String> getPlafondPrixParam() {
		return plafondPrixParam;
	}

	public void setPlafondPrixParam(SearchParam<String> plafondPrixParam) {
		this.plafondPrixParam = plafondPrixParam;
	}

	public SearchParam<String> getPrincipeActifParam() {
		return principeActifParam;
	}

	public void setPrincipeActifParam(SearchParam<String> principeActifParam) {
		this.principeActifParam = principeActifParam;
	}

	public SearchParam<String> getLaboratoireParam() {
		return laboratoireParam;
	}

	public void setLaboratoireParam(SearchParam<String> laboratoireParam) {
		this.laboratoireParam = laboratoireParam;
	}

	public SearchParam<String> getDescriptionParam() {
		return descriptionParam;
	}

	public void setDescriptionParam(SearchParam<String> descriptionParam) {
		this.descriptionParam = descriptionParam;
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
    protected Integer    statusId             ;
	protected String     updatedAt            ;
    protected Integer    updatedBy            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   libelleParam          ;                     
	protected SearchParam<String>   dosageParam           ;                     
	protected SearchParam<String>   formePharmaceutiqueParam;                     
	protected SearchParam<String>   plafondPrixParam      ;                     
	protected SearchParam<String>   principeActifParam    ;                     
	protected SearchParam<String>   laboratoireParam      ;                     
	protected SearchParam<String>   descriptionParam      ;                     
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
