/*
 * Created on 2024-12-01 ( Time 21:32:04 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.wdyapplications.pharmapp.dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "commande"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="commande" )
public class Commande implements Serializable, Cloneable {

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
    @Column(name="prix_total", columnDefinition = "TEXT")
    private String     prixTotal    ;

    @Column(name="mode_recuperation", columnDefinition = "TEXT")
    private String     modeRecuperation ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date       createdAt    ;

    @Column(name="created_by")
    private Integer    createdBy    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date       deletedAt    ;

    @Column(name="is_deleted")
    private Boolean    isDeleted    ;
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name="status_id")
    private Integer    statusId     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date       updatedAt    ;

    @Column(name="updated_by")
    private Integer    updatedBy    ;

	// "userId" (column "user_id") is not defined by itself because used as FK in a link 
	// "ordonnanceId" (column "ordonnance_id") is not defined by itself because used as FK in a link 
	// "pharmacieId" (column "pharmacie_id") is not defined by itself because used as FK in a link 
	// "adresseId" (column "adresse_id") is not defined by itself because used as FK in a link 
	// "assuranceId" (column "assurance_id") is not defined by itself because used as FK in a link 

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="pharmacie_id", referencedColumnName="id")
    private Pharmacie pharmacie   ;
    @ManyToOne
    @JoinColumn(name="assurance_id", referencedColumnName="id")
    private Assurances assurances  ;
    @ManyToOne
    @JoinColumn(name="ordonnance_id", referencedColumnName="id")
    private Ordonnance ordonnance  ;
    @ManyToOne
    @JoinColumn(name="adresse_id", referencedColumnName="id")
    private Adresse adresse     ;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private Users users       ;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Assurances getAssurances() {
        return assurances;
    }

    public void setAssurances(Assurances assurances) {
        this.assurances = assurances;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Commande() {
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
