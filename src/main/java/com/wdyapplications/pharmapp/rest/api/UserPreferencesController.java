

/*
 * Java controller for entity table user_preferences 
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
Controller for table "user_preferences"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/userPreferences")
public class UserPreferencesController {

	@Autowired
    private ControllerFactory<UserPreferencesDto> controllerFactory;
	@Autowired
	private UserPreferencesBusiness userPreferencesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserPreferencesDto> create(@RequestBody Request<UserPreferencesDto> request) {
    	// System.out.println("start method /userPreferences/create");
        Response<UserPreferencesDto> response = controllerFactory.create(userPreferencesBusiness, request, FunctionalityEnum.CREATE_USER_PREFERENCES);
		// System.out.println("end method /userPreferences/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserPreferencesDto> update(@RequestBody Request<UserPreferencesDto> request) {
    	// System.out.println("start method /userPreferences/update");
        Response<UserPreferencesDto> response = controllerFactory.update(userPreferencesBusiness, request, FunctionalityEnum.UPDATE_USER_PREFERENCES);
		// System.out.println("end method /userPreferences/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserPreferencesDto> delete(@RequestBody Request<UserPreferencesDto> request) {
    	// System.out.println("start method /userPreferences/delete");
        Response<UserPreferencesDto> response = controllerFactory.delete(userPreferencesBusiness, request, FunctionalityEnum.DELETE_USER_PREFERENCES);
		// System.out.println("end method /userPreferences/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserPreferencesDto> getByCriteria(@RequestBody Request<UserPreferencesDto> request) {
    	// System.out.println("start method /userPreferences/getByCriteria");
        Response<UserPreferencesDto> response = controllerFactory.getByCriteria(userPreferencesBusiness, request, FunctionalityEnum.VIEW_USER_PREFERENCES);
		// System.out.println("end method /userPreferences/getByCriteria");
        return response;
    }
}
