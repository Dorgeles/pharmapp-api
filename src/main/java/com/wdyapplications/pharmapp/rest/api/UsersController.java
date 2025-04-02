

/*
 * Java controller for entity table users 
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
Controller for table "users"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/users")
public class UsersController {

	@Autowired
    private ControllerFactory<UsersDto> controllerFactory;
	@Autowired
	private UsersBusiness usersBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> create(@RequestBody Request<UsersDto> request) {
    	// System.out.println("start method /users/create");
        Response<UsersDto> response = controllerFactory.create(usersBusiness, request, FunctionalityEnum.CREATE_USERS);
		// System.out.println("end method /users/create");
        return response;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> login(@RequestBody Request<UsersDto> request) throws ParseException {
        // System.out.println("start method /users/create");
        Response<UsersDto> response = usersBusiness.login(request, Locale.FRENCH);
        // System.out.println("end method /users/create");
        return response;
    }

    @RequestMapping(value="/initRessetPassword",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> initRessetPassword(@RequestBody Request<UsersDto> request) throws ParseException {
        // System.out.println("start method /users/create");
        Response<UsersDto> response = usersBusiness.initRessetPassword(request, Locale.FRENCH);
        // System.out.println("end method /users/create");
        return response;
    }

    @RequestMapping(value="/resetPassword",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> resetPassword(@RequestBody Request<UsersDto> request) throws ParseException {
        // System.out.println("start method /users/create");
        Response<UsersDto> response = usersBusiness.resetPassword(request, Locale.FRENCH);
        // System.out.println("end method /users/create");
        return response;
    } //changePassword

    @RequestMapping(value="/changePassword",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> changePassword(@RequestBody Request<UsersDto> request) throws ParseException {
        // System.out.println("start method /users/create");
        Response<UsersDto> response = usersBusiness.changePassword(request, Locale.FRENCH);
        // System.out.println("end method /users/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> update(@RequestBody Request<UsersDto> request) {
    	// System.out.println("start method /users/update");
        Response<UsersDto> response = controllerFactory.update(usersBusiness, request, FunctionalityEnum.UPDATE_USERS);
		// System.out.println("end method /users/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> delete(@RequestBody Request<UsersDto> request) {
    	// System.out.println("start method /users/delete");
        Response<UsersDto> response = controllerFactory.delete(usersBusiness, request, FunctionalityEnum.DELETE_USERS);
		// System.out.println("end method /users/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UsersDto> getByCriteria(@RequestBody Request<UsersDto> request) {
    	// System.out.println("start method /users/getByCriteria");
        Response<UsersDto> response = controllerFactory.getByCriteria(usersBusiness, request, FunctionalityEnum.VIEW_USERS);
		// System.out.println("end method /users/getByCriteria");
        return response;
    }
}
