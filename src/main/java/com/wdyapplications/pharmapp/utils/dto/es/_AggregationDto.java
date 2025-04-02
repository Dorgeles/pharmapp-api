/*
 * Created on 2021-12-20 ( Time 03:18:40 )
 * Generator tool : Telosys Tools Generator ( version 3.1.2 )
 * Copyright 2019 Smile CI. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.es;

import java.util.List;

public class _AggregationDto implements Cloneable {

	private String 					field;
	private Integer 				size;
	private List<_AggregationDto> 	datasSubAggregation;
	
	//Sort
	private String 					orderDirection;
	private String 					orderField;
	private Boolean 				manualSorting;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<_AggregationDto> getDatasSubAggregation() {
		return datasSubAggregation;
	}

	public void setDatasSubAggregation(List<_AggregationDto> datasSubAggregation) {
		this.datasSubAggregation = datasSubAggregation;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public Boolean getManualSorting() {
		return manualSorting;
	}

	public void setManualSorting(Boolean manualSorting) {
		this.manualSorting = manualSorting;
	}

	public _AggregationDto(String field, Integer size, String orderDirection, String orderField, Boolean manualSorting, List<_AggregationDto> datasSubAggregation) {
		this.field = field;
		this.size = size;
		this.datasSubAggregation = datasSubAggregation;
		this.orderDirection = orderDirection;
		this.orderField = orderField;
		this.manualSorting = manualSorting;
	}
	
	public _AggregationDto(String field, Integer size, String orderDirection, String orderField, List<_AggregationDto> datasSubAggregation) {
		this(field, size, orderDirection, orderField, null, datasSubAggregation);
	}
	
	public _AggregationDto(String field, Integer size, String orderDirection, String orderField) {
		this(field, size, orderDirection, orderField, null);
	}
	
	public _AggregationDto(String field, Integer size, List<_AggregationDto> datasSubAggregation) {
		this(field, size, null, null, datasSubAggregation);
	}
	
	@Override
	public _AggregationDto clone() throws CloneNotSupportedException {
		return (_AggregationDto) super.clone();
	}

}