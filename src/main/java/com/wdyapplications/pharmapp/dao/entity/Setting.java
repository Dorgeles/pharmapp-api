/*
 * Created on 2024-11-16 ( Time 14:29:24 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.wdyapplications.pharmapp.dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "setting"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="setting" )
public class Setting implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    // test value Integer
        private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code", length=255)
    private String     code         ;

    @Column(name="valeur", columnDefinition = "TEXT")
    private String     valeur       ;

    @Column(name="status_id")
    private Integer    statusId     ;

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

    @Column(name="created_by")
    private Integer    createdBy    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date       deletedAt    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date       updatedAt    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date       createdAt    ;

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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
    public Setting() {
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
