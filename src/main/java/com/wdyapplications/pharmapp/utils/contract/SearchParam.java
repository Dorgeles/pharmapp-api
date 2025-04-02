
/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.contract;

import java.util.List;


/**
 * Search Param
 * 
 * @author Geo
 *
 */

public class SearchParam<T> {
	String  operator;
    T       start;
    T       end;
    List<T> datas;
    Float   distance;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public SearchParam(String operator, T start, T end, List<T> datas, Float distance) {
        super();
        this.operator = operator;
        this.start    = start;
        this.end      = end;
        this.datas    = datas;
        this.distance = distance;
    }

    public SearchParam(String operator, T start, T end, List<T> datas) {
        this(operator, start, end, datas, null);
    }

    public SearchParam(String operator) {
        this(operator, null, null, null);
    }

    public SearchParam(String operator, T start, T end) {
        this(operator, start, end, null);
    }

    public SearchParam(String operator, List<T> datas) {
        this(operator, null, null, datas);
    }

    public SearchParam(String operator, Float distance) {
        this(operator, null, null, null, distance);
    }
}
