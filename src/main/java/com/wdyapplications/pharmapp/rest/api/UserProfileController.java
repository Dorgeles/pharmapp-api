

/*
 * Java controller for entity table user_profile 
 * Created on 2024-11-08 ( Time 00:24:09 )
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
Controller for table "user_profile"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/userProfile")
public class UserProfileController {

	@Autowired
    private ControllerFactory<UserProfileDto> controllerFactory;
	@Autowired
	private UserProfileBusiness userProfileBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserProfileDto> create(@RequestBody Request<UserProfileDto> request) {
    	// System.out.println("start method /userProfile/create");
        Response<UserProfileDto> response = controllerFactory.create(userProfileBusiness, request, FunctionalityEnum.CREATE_USER_PROFILE);
		// System.out.println("end method /userProfile/create");
        return response;
    }

    @RequestMapping(value="/createUsers",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserProfileDto> createUsers(@RequestBody Request<UserProfileDto> request) throws ParseException {
        // System.out.println("start method /userProfile/create");
        Response<UserProfileDto> response = userProfileBusiness.createUser(request, Locale.FRENCH);
        // System.out.println("end method /userProfile/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserProfileDto> update(@RequestBody Request<UserProfileDto> request) {
    	// System.out.println("start method /userProfile/update");
        Response<UserProfileDto> response = controllerFactory.update(userProfileBusiness, request, FunctionalityEnum.UPDATE_USER_PROFILE);
		// System.out.println("end method /userProfile/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserProfileDto> delete(@RequestBody Request<UserProfileDto> request) {
    	// System.out.println("start method /userProfile/delete");
        Response<UserProfileDto> response = controllerFactory.delete(userProfileBusiness, request, FunctionalityEnum.DELETE_USER_PROFILE);
		// System.out.println("end method /userProfile/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserProfileDto> getByCriteria(@RequestBody Request<UserProfileDto> request) {
    	// System.out.println("start method /userProfile/getByCriteria");
        Response<UserProfileDto> response = controllerFactory.getByCriteria(userProfileBusiness, request, FunctionalityEnum.VIEW_USER_PROFILE);
		// System.out.println("end method /userProfile/getByCriteria");
        return response;
    }
}
