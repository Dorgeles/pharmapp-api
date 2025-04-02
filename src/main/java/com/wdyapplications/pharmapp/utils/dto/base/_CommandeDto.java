
/*
 * Java dto for entity table commande 
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.base;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO customize for table "commande"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _CommandeDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     prixTotal            ;
    protected String     modeRecuperation     ;
    protected Integer    userId               ;
    protected Integer    ordonnanceId         ;
    protected Integer    pharmacieId          ;
    protected Integer    adresseId            ;
    protected Integer    assuranceId          ;
	protected String     createdAt            ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(String prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String getModeRecuperation() {
		return modeRecuperation;
	}

	public void setModeRecuperation(String modeRecuperation) {
		this.modeRecuperation = modeRecuperation;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrdonnanceId() {
		return ordonnanceId;
	}

	public void setOrdonnanceId(Integer ordonnanceId) {
		this.ordonnanceId = ordonnanceId;
	}

	public Integer getPharmacieId() {
		return pharmacieId;
	}

	public void setPharmacieId(Integer pharmacieId) {
		this.pharmacieId = pharmacieId;
	}

	public Integer getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(Integer adresseId) {
		this.adresseId = adresseId;
	}

	public Integer getAssuranceId() {
		return assuranceId;
	}

	public void setAssuranceId(Integer assuranceId) {
		this.assuranceId = assuranceId;
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

	public String getPharmacieNom() {
		return pharmacieNom;
	}

	public void setPharmacieNom(String pharmacieNom) {
		this.pharmacieNom = pharmacieNom;
	}

	public String getPharmacieTelephone() {
		return pharmacieTelephone;
	}

	public void setPharmacieTelephone(String pharmacieTelephone) {
		this.pharmacieTelephone = pharmacieTelephone;
	}

	public String getPharmacieEmail() {
		return pharmacieEmail;
	}

	public void setPharmacieEmail(String pharmacieEmail) {
		this.pharmacieEmail = pharmacieEmail;
	}

	public String getAssurancesLibelle() {
		return assurancesLibelle;
	}

	public void setAssurancesLibelle(String assurancesLibelle) {
		this.assurancesLibelle = assurancesLibelle;
	}

	public String getAdresseLibelle() {
		return adresseLibelle;
	}

	public void setAdresseLibelle(String adresseLibelle) {
		this.adresseLibelle = adresseLibelle;
	}

	public String getUsersEmail() {
		return usersEmail;
	}

	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}

	public SearchParam<Integer> getIdParam() {
		return idParam;
	}

	public void setIdParam(SearchParam<Integer> idParam) {
		this.idParam = idParam;
	}

	public SearchParam<String> getPrixTotalParam() {
		return prixTotalParam;
	}

	public void setPrixTotalParam(SearchParam<String> prixTotalParam) {
		this.prixTotalParam = prixTotalParam;
	}

	public SearchParam<String> getModeRecuperationParam() {
		return modeRecuperationParam;
	}

	public void setModeRecuperationParam(SearchParam<String> modeRecuperationParam) {
		this.modeRecuperationParam = modeRecuperationParam;
	}

	public SearchParam<Integer> getUserIdParam() {
		return userIdParam;
	}

	public void setUserIdParam(SearchParam<Integer> userIdParam) {
		this.userIdParam = userIdParam;
	}

	public SearchParam<Integer> getOrdonnanceIdParam() {
		return ordonnanceIdParam;
	}

	public void setOrdonnanceIdParam(SearchParam<Integer> ordonnanceIdParam) {
		this.ordonnanceIdParam = ordonnanceIdParam;
	}

	public SearchParam<Integer> getPharmacieIdParam() {
		return pharmacieIdParam;
	}

	public void setPharmacieIdParam(SearchParam<Integer> pharmacieIdParam) {
		this.pharmacieIdParam = pharmacieIdParam;
	}

	public SearchParam<Integer> getAdresseIdParam() {
		return adresseIdParam;
	}

	public void setAdresseIdParam(SearchParam<Integer> adresseIdParam) {
		this.adresseIdParam = adresseIdParam;
	}

	public SearchParam<Integer> getAssuranceIdParam() {
		return assuranceIdParam;
	}

	public void setAssuranceIdParam(SearchParam<Integer> assuranceIdParam) {
		this.assuranceIdParam = assuranceIdParam;
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

	public SearchParam<Integer> getPharmacieParam() {
		return pharmacieParam;
	}

	public void setPharmacieParam(SearchParam<Integer> pharmacieParam) {
		this.pharmacieParam = pharmacieParam;
	}

	public SearchParam<String> getPharmacieNomParam() {
		return pharmacieNomParam;
	}

	public void setPharmacieNomParam(SearchParam<String> pharmacieNomParam) {
		this.pharmacieNomParam = pharmacieNomParam;
	}

	public SearchParam<String> getPharmacieTelephoneParam() {
		return pharmacieTelephoneParam;
	}

	public void setPharmacieTelephoneParam(SearchParam<String> pharmacieTelephoneParam) {
		this.pharmacieTelephoneParam = pharmacieTelephoneParam;
	}

	public SearchParam<String> getPharmacieEmailParam() {
		return pharmacieEmailParam;
	}

	public void setPharmacieEmailParam(SearchParam<String> pharmacieEmailParam) {
		this.pharmacieEmailParam = pharmacieEmailParam;
	}

	public SearchParam<Integer> getAssurancesParam() {
		return assurancesParam;
	}

	public void setAssurancesParam(SearchParam<Integer> assurancesParam) {
		this.assurancesParam = assurancesParam;
	}

	public SearchParam<String> getAssurancesLibelleParam() {
		return assurancesLibelleParam;
	}

	public void setAssurancesLibelleParam(SearchParam<String> assurancesLibelleParam) {
		this.assurancesLibelleParam = assurancesLibelleParam;
	}

	public SearchParam<Integer> getOrdonnanceParam() {
		return ordonnanceParam;
	}

	public void setOrdonnanceParam(SearchParam<Integer> ordonnanceParam) {
		this.ordonnanceParam = ordonnanceParam;
	}

	public SearchParam<Integer> getAdresseParam() {
		return adresseParam;
	}

	public void setAdresseParam(SearchParam<Integer> adresseParam) {
		this.adresseParam = adresseParam;
	}

	public SearchParam<String> getAdresseLibelleParam() {
		return adresseLibelleParam;
	}

	public void setAdresseLibelleParam(SearchParam<String> adresseLibelleParam) {
		this.adresseLibelleParam = adresseLibelleParam;
	}

	public SearchParam<Integer> getUsersParam() {
		return usersParam;
	}

	public void setUsersParam(SearchParam<Integer> usersParam) {
		this.usersParam = usersParam;
	}

	public SearchParam<String> getUsersEmailParam() {
		return usersEmailParam;
	}

	public void setUsersEmailParam(SearchParam<String> usersEmailParam) {
		this.usersEmailParam = usersEmailParam;
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
	//protected Integer    pharmacie;
	protected String pharmacieNom;
	protected String pharmacieTelephone;
	protected String pharmacieEmail;
	//protected Integer    assurances;
	protected String assurancesLibelle;
	//protected Integer    ordonnance;
	//protected Integer    adresse;
	protected String adresseLibelle;
	//protected Integer    users;
	protected String usersEmail;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   prixTotalParam        ;                     
	protected SearchParam<String>   modeRecuperationParam ;                     
	protected SearchParam<Integer>  userIdParam           ;                     
	protected SearchParam<Integer>  ordonnanceIdParam     ;                     
	protected SearchParam<Integer>  pharmacieIdParam      ;                     
	protected SearchParam<Integer>  adresseIdParam        ;                     
	protected SearchParam<Integer>  assuranceIdParam      ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Integer>  pharmacieParam        ;                     
	protected SearchParam<String>   pharmacieNomParam     ;                     
	protected SearchParam<String>   pharmacieTelephoneParam;                     
	protected SearchParam<String>   pharmacieEmailParam   ;                     
	protected SearchParam<Integer>  assurancesParam       ;                     
	protected SearchParam<String>   assurancesLibelleParam;                     
	protected SearchParam<Integer>  ordonnanceParam       ;                     
	protected SearchParam<Integer>  adresseParam          ;                     
	protected SearchParam<String>   adresseLibelleParam   ;                     
	protected SearchParam<Integer>  usersParam            ;                     
	protected SearchParam<String>   usersEmailParam       ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
