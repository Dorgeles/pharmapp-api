

/*
 * Java controller for entity table otp 
 * Created on 2024-12-01 ( Time 21:32:05 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.rest.api;


import com.wdyapplications.pharmapp.business.*;
import com.wdyapplications.pharmapp.rest.fact.ControllerFactory;
import com.wdyapplications.pharmapp.utils.*;
import com.wdyapplications.pharmapp.utils.contract.*;
import com.wdyapplications.pharmapp.utils.contract.Request;
import com.wdyapplications.pharmapp.utils.contract.Response;
import com.wdyapplications.pharmapp.utils.dto.*;
import com.wdyapplications.pharmapp.utils.enums.FunctionalityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Locale;

/**
Controller for table "otp"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/otp")
public class OtpController {

	@Autowired
    private ControllerFactory<OtpDto> controllerFactory;
	@Autowired
	private OtpBusiness otpBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OtpDto> create(@RequestBody Request<OtpDto> request) {
    	// System.out.println("start method /otp/create");
        Response<OtpDto> response = controllerFactory.create(otpBusiness, request, FunctionalityEnum.CREATE_OTP);
		// System.out.println("end method /otp/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OtpDto> update(@RequestBody Request<OtpDto> request) {
    	// System.out.println("start method /otp/update");
        Response<OtpDto> response = controllerFactory.update(otpBusiness, request, FunctionalityEnum.UPDATE_OTP);
		// System.out.println("end method /otp/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OtpDto> delete(@RequestBody Request<OtpDto> request) {
    	// System.out.println("start method /otp/delete");
        Response<OtpDto> response = controllerFactory.delete(otpBusiness, request, FunctionalityEnum.DELETE_OTP);
		// System.out.println("end method /otp/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OtpDto> getByCriteria(@RequestBody Request<OtpDto> request) {
    	// System.out.println("start method /otp/getByCriteria");
        Response<OtpDto> response = controllerFactory.getByCriteria(otpBusiness, request, FunctionalityEnum.VIEW_OTP);
		// System.out.println("end method /otp/getByCriteria");
        return response;
    }

    @RequestMapping(value="/confirmOtp",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OtpDto> confirmOtp(@RequestBody Request<OtpDto> request) throws Exception {
        // System.out.println("start method /otp/getByCriteria");
        Response<OtpDto> response = otpBusiness.confirmOtp(request, Locale.FRENCH);
        //System.out.println(response.getItems().toString());
        return response;
    }
}
