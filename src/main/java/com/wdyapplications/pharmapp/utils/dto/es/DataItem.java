package com.wdyapplications.pharmapp.utils.dto.es;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class DataItem {
    private String type;
    private String libelle;
    private String key;
    private String value;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
