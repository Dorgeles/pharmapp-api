
/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils.contract;

import java.text.ParseException;
import java.util.Locale;

/**
 * IBasic Business
 * 
 * @author Geo
 *
 */
public interface IBasicBusiness<T, K> {

	/**
	 * create Object by using T as object.
	 * 
	 * @param T
	 * @return K
	 * @throws ParseException 
	 * 
	 */
	K create(T request, Locale locale) throws ParseException;

	/**
	 * update Object by using T as object.
	 * 
	 * @param T
	 * @return K
	 * 
	 */
	K update(T request, Locale locale) throws ParseException;

	/**
	 * delete Object by using T as object.
	 * 
	 * @param T
	 * @return K
	 * 
	 */
	K delete(T request, Locale locale);

	/**
	 * get a List of Object by using T as criteria object.
	 * 
	 * @param T
	 * @return K
	 * 
	 */
	K getByCriteria(T request, Locale locale) throws Exception;
}
