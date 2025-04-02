/*
 * Created on 2021-12-20 ( Time 03:18:40 )
 * Generator tool : Telosys Tools Generator ( version 3.1.2 )
 * Copyright 2019 Smile CI. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.dto.es;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Comparator;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _AggregationResponseDto {

	private String 								name;
	private Long 								total;
	private Long 								sum_other_doc_count;
	private Long 								doc_count_error_upper_bound;
	private List<_AggregationResponseDto>		buckets;
	private Long 								size;
	
	
	private String 								drilldown;
	private String 								value;
	private Long 								y;
	private Double 								taux;
	private _AggregationResponseDto 			data;
	private List<_AggregationResponseDto>		datas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getSum_other_doc_count() {
		return sum_other_doc_count;
	}

	public void setSum_other_doc_count(Long sum_other_doc_count) {
		this.sum_other_doc_count = sum_other_doc_count;
	}

	public Long getDoc_count_error_upper_bound() {
		return doc_count_error_upper_bound;
	}

	public void setDoc_count_error_upper_bound(Long doc_count_error_upper_bound) {
		this.doc_count_error_upper_bound = doc_count_error_upper_bound;
	}

	public List<_AggregationResponseDto> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<_AggregationResponseDto> buckets) {
		this.buckets = buckets;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDrilldown() {
		return drilldown;
	}

	public void setDrilldown(String drilldown) {
		this.drilldown = drilldown;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public _AggregationResponseDto getData() {
		return data;
	}

	public void setData(_AggregationResponseDto data) {
		this.data = data;
	}

	public List<_AggregationResponseDto> getDatas() {
		return datas;
	}

	public void setDatas(List<_AggregationResponseDto> datas) {
		this.datas = datas;
	}

	public static Comparator<_AggregationResponseDto> getComparator(String orderField){
		if(orderField.equalsIgnoreCase("name")) {
			return Comparator.comparing(d -> d.getName());
		}
		else if(orderField.equalsIgnoreCase("total")) {
			return Comparator.comparing(d -> d.getTotal());
		}
		else if(orderField.equalsIgnoreCase("sum_other_doc_count")) {
			return Comparator.comparing(d -> d.getSum_other_doc_count());
		}
		else if(orderField.equalsIgnoreCase("doc_count_error_upper_bound")) {
			return Comparator.comparing(d -> d.getDoc_count_error_upper_bound());
		}
		else if(orderField.equalsIgnoreCase("drilldown")) {
			return Comparator.comparing(d -> d.getDrilldown());
		}
		else if(orderField.equalsIgnoreCase("value")) {
			return Comparator.comparing(d -> d.getValue());
		}
		else if(orderField.equalsIgnoreCase("y")) {
			return Comparator.comparing(d -> d.getY());
		}
		else if(orderField.equalsIgnoreCase("taux")) {
			return Comparator.comparing(d -> d.getTaux());
		}
		
		return Comparator.comparing(d -> d.getName());
	}
	

}
