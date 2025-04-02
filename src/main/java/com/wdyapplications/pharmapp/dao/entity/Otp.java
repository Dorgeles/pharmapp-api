/*
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.wdyapplications.pharmapp.dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "otp"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="otp" )
public class Otp implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    // test value Integer
        private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code_otp", length=255)
    private String     codeOtp      ;

    @Column(name="identifier", length=255)
    private String     identifier   ;

    @Column(name="origine_element_id")
    private Integer    origineElementId ;

    @Column(name="is_expired")
    private Boolean    isExpired    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="expire_on")
    private Date       expireOn     ;

    @Column(name="token", length=255)
    private String     token        ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date       updatedAt    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date       deletedAt    ;

    @Column(name="created_by")
    private Integer    createdBy    ;

    @Column(name="updated_by")
    private Integer    updatedBy    ;

    @Column(name="is_deleted")
    private Boolean    isDeleted    ;
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    @Column(name="commentaire", columnDefinition = "TEXT")
    private String     commentaire  ;

    @Column(name="status_id")
    private Integer    statusId     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date       createdAt    ;

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

    public Date getExpireOn() {
        return expireOn;
    }

    public void setExpireOn(Date expireOn) {
        this.expireOn = expireOn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
//----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Otp() {
		super();
    }
    
	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
