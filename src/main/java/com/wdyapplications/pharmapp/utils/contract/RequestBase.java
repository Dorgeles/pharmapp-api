/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.contract;



/**
 * Request Base
 * 
 * @author Geo
 *
 */


public class RequestBase {
	protected String		sessionUser;
	protected Integer		size;
	protected Integer		index;
	protected String		lang;
	protected Boolean		isAnd;
	protected Integer		user;
	protected Boolean 		isSimpleLoading;
    protected String        action;
	protected Boolean    isDeleted            ;
	public Boolean getIsAnd() {
		return isAnd;
	}
	public void setIsAnd(Boolean isAnd) {
		this.isAnd = isAnd;
	}
	public Boolean getIsSimpleLoading() {
		return isSimpleLoading;
	}
	public void setIsSimpleLoading(Boolean isSimpleLoading) {
		this.isSimpleLoading = isSimpleLoading;
	}

	public String getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(String sessionUser) {
		this.sessionUser = sessionUser;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Boolean getAnd() {
		return isAnd;
	}

	public void setAnd(Boolean and) {
		isAnd = and;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Boolean getSimpleLoading() {
		return isSimpleLoading;
	}

	public void setSimpleLoading(Boolean simpleLoading) {
		isSimpleLoading = simpleLoading;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}