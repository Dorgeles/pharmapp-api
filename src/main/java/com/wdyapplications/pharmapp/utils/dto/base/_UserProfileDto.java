
/*
 * Java dto for entity table user_profile 
 * Created on 2024-11-19 ( Time 17:06:07 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.base;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO customize for table "user_profile"
 * 
 * @author Smile Back-End generator
 *
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _UserProfileDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     firstname            ;
    protected String     lastname             ;
    protected String     profilePicture       ;
    protected String     contact              ;
    protected Integer    userId               ;
	protected String     createdAt            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public SearchParam<String> getFirstnameParam() {
		return firstnameParam;
	}

	public void setFirstnameParam(SearchParam<String> firstnameParam) {
		this.firstnameParam = firstnameParam;
	}

	public SearchParam<String> getLastnameParam() {
		return lastnameParam;
	}

	public void setLastnameParam(SearchParam<String> lastnameParam) {
		this.lastnameParam = lastnameParam;
	}

	public SearchParam<String> getProfilePictureParam() {
		return profilePictureParam;
	}

	public void setProfilePictureParam(SearchParam<String> profilePictureParam) {
		this.profilePictureParam = profilePictureParam;
	}

	public SearchParam<String> getContactParam() {
		return contactParam;
	}

	public void setContactParam(SearchParam<String> contactParam) {
		this.contactParam = contactParam;
	}

	public SearchParam<Integer> getUserIdParam() {
		return userIdParam;
	}

	public void setUserIdParam(SearchParam<Integer> userIdParam) {
		this.userIdParam = userIdParam;
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
	//protected Integer    users;
	protected String usersEmail;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   firstnameParam        ;                     
	protected SearchParam<String>   lastnameParam         ;                     
	protected SearchParam<String>   profilePictureParam   ;                     
	protected SearchParam<String>   contactParam          ;                     
	protected SearchParam<Integer>  userIdParam           ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Integer>  usersParam            ;                     
	protected SearchParam<String>   usersEmailParam       ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
