
/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils;

import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


/**
 * Technical Error
 * 
 * @author Geo
 *
 */

@XmlRootElement
@Component
public class TechnicalError {

	private String			code;
	private String			message;
	@Autowired
	private MessageSource	messageSource;
	
	private static Status	status	= new Status();

	public Status DB_NOT_CONNECT(String message, Locale locale) {
		status.setCode(StatusCode.TECH_DB_NOT_CONNECT);
		status.setMessage(messageSource.getMessage("StatusMessage.TECH_DB_NOT_CONNECT", new Object[] {}, locale) + ": " + message);
		return status;
	}

	public Status DB_FAIL(String message, Locale locale) {
		status.setCode(StatusCode.TECH_DB_FAIL);
		status.setMessage(messageSource.getMessage("StatusMessage.TECH_DB_FAIL", new Object[] {}, locale) + ": " + message);
		return status;
	}

	public Status INTERN_ERROR(String message, Locale locale) {
		status.setCode(StatusCode.TECH_INTERN_ERROR);
		String msg = messageSource.getMessage("StatusMessage.TECH_INTERN_ERROR", new Object[] {}, locale);
		status.setMessage(msg + ": " + message);
		return status;
	}

	public Status DB_PERMISSION_DENIED(String message, Locale locale) {
		status.setCode(StatusCode.TECH_DB_PERMISSION_DENIED);
		status.setMessage(messageSource.getMessage("StatusMessage.TECH_DB_PERMISSION_DENIED", new Object[] {}, locale) + ": " + message);
		return status;
	}

	public Status DB_QUERY_REFUSED(String message, Locale locale) {
		status.setCode(StatusCode.TECH_DB_QUERY_REFUSED);
		status.setMessage(messageSource.getMessage("StatusMessage.TECH_DB_QUERY_REFUSED", new Object[] {}, locale) + ": " + message);
		return status;
	}

	public Status ERROR(String message, Locale locale) {
		String[] msgTab = message.split(";");
		if (msgTab != null && msgTab.length > 1) {
			status.setCode(msgTab[0]);
			status.setMessage(msgTab[1]);
		} else {
			status.setCode(StatusCode.FUNC_FAIL);
			status.setMessage(message);
		}
		return status;
	}
}
