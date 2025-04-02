

/*
 * Java controller for entity table user_activity 
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

/**
Controller for table "user_activity"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/userActivity")
public class UserActivityController {

	@Autowired
    private ControllerFactory<UserActivityDto> controllerFactory;
	@Autowired
	private UserActivityBusiness userActivityBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserActivityDto> create(@RequestBody Request<UserActivityDto> request) {
    	// System.out.println("start method /userActivity/create");
        Response<UserActivityDto> response = controllerFactory.create(userActivityBusiness, request, FunctionalityEnum.CREATE_USER_ACTIVITY);
		// System.out.println("end method /userActivity/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserActivityDto> update(@RequestBody Request<UserActivityDto> request) {
    	// System.out.println("start method /userActivity/update");
        Response<UserActivityDto> response = controllerFactory.update(userActivityBusiness, request, FunctionalityEnum.UPDATE_USER_ACTIVITY);
		// System.out.println("end method /userActivity/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserActivityDto> delete(@RequestBody Request<UserActivityDto> request) {
    	// System.out.println("start method /userActivity/delete");
        Response<UserActivityDto> response = controllerFactory.delete(userActivityBusiness, request, FunctionalityEnum.DELETE_USER_ACTIVITY);
		// System.out.println("end method /userActivity/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserActivityDto> getByCriteria(@RequestBody Request<UserActivityDto> request) {
    	// System.out.println("start method /userActivity/getByCriteria");
        Response<UserActivityDto> response = controllerFactory.getByCriteria(userActivityBusiness, request, FunctionalityEnum.VIEW_USER_ACTIVITY);
		// System.out.println("end method /userActivity/getByCriteria");
        return response;
    }
}
