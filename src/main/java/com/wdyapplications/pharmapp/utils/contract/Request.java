
/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.contract;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * Request
 * 
 * @author Geo
 *
 */

@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class Request<T> extends RequestBase {
	protected T			data;
	protected List<T>	datas;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}