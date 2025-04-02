

/*
 * Java controller for entity table setting 
 * Created on 2024-11-16 ( Time 14:29:24 )
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
Controller for table "setting"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/setting")
public class SettingController {

	@Autowired
    private ControllerFactory<SettingDto> controllerFactory;
	@Autowired
	private SettingBusiness settingBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> create(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/create");
        Response<SettingDto> response = controllerFactory.create(settingBusiness, request, FunctionalityEnum.CREATE_SETTING);
		// System.out.println("end method /setting/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> update(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/update");
        Response<SettingDto> response = controllerFactory.update(settingBusiness, request, FunctionalityEnum.UPDATE_SETTING);
		// System.out.println("end method /setting/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> delete(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/delete");
        Response<SettingDto> response = controllerFactory.delete(settingBusiness, request, FunctionalityEnum.DELETE_SETTING);
		// System.out.println("end method /setting/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> getByCriteria(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/getByCriteria");
        Response<SettingDto> response = controllerFactory.getByCriteria(settingBusiness, request, FunctionalityEnum.VIEW_SETTING);
		// System.out.println("end method /setting/getByCriteria");
        return response;
    }
}
