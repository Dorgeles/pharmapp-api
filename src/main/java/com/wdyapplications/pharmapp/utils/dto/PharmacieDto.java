
/*
 * Java dto for entity table pharmacie
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto;

import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.dto.base._PharmacieDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * DTO for table "pharmacie"
 *
 * @author Geo
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class PharmacieDto extends _PharmacieDto {

    private String statusLibelle;

    public String getStatusLibelle() {
        return statusLibelle;
    }

    public void setStatusLibelle(String statusLibelle) {
        this.statusLibelle = statusLibelle;
    }

    private List<ImageDto> images;

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    //----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
