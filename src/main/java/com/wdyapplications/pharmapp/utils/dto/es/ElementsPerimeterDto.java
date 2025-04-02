package com.wdyapplications.pharmapp.utils.dto.es;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wdyapplications.pharmapp.utils.contract.SearchParam;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ElementsPerimeterDto implements Cloneable {
	
	private String                   _id;
	private String                   _index;
	private String                   id;
	private String                   origin;
	private String                   type;
	private Map<String, Object>      geometry;
	private Map<String, Object>      properties;
	private String                   code;
	private String                   createdAt;

	// Search param                     
	private SearchParam<String>      idParam;
	private SearchParam<String>      originParam;
	private SearchParam<String>      typeParam;
	private SearchParam<String>      geometryParam;                     
	private SearchParam<String>      propertiesParam;
	private SearchParam<String>      codeParam;
	private SearchParam<String>      createdAtParam;

	// Ordering params
	private String                   orderDirection;
	private String                   orderField;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_index() {
		return _index;
	}

	public void set_index(String _index) {
		this._index = _index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, Object> getGeometry() {
		return geometry;
	}

	public void setGeometry(Map<String, Object> geometry) {
		this.geometry = geometry;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public SearchParam<String> getIdParam() {
		return idParam;
	}

	public void setIdParam(SearchParam<String> idParam) {
		this.idParam = idParam;
	}

	public SearchParam<String> getOriginParam() {
		return originParam;
	}

	public void setOriginParam(SearchParam<String> originParam) {
		this.originParam = originParam;
	}

	public SearchParam<String> getTypeParam() {
		return typeParam;
	}

	public void setTypeParam(SearchParam<String> typeParam) {
		this.typeParam = typeParam;
	}

	public SearchParam<String> getGeometryParam() {
		return geometryParam;
	}

	public void setGeometryParam(SearchParam<String> geometryParam) {
		this.geometryParam = geometryParam;
	}

	public SearchParam<String> getPropertiesParam() {
		return propertiesParam;
	}

	public void setPropertiesParam(SearchParam<String> propertiesParam) {
		this.propertiesParam = propertiesParam;
	}

	public SearchParam<String> getCodeParam() {
		return codeParam;
	}

	public void setCodeParam(SearchParam<String> codeParam) {
		this.codeParam = codeParam;
	}

	public SearchParam<String> getCreatedAtParam() {
		return createdAtParam;
	}

	public void setCreatedAtParam(SearchParam<String> createdAtParam) {
		this.createdAtParam = createdAtParam;
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

	@Override
	public ElementsPerimeterDto clone() throws CloneNotSupportedException {
		return (ElementsPerimeterDto) super.clone();
	}
}
