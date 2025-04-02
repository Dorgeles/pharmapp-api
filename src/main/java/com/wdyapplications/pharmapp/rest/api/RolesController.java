

/*
 * Java controller for entity table roles 
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
Controller for table "roles"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/roles")
public class RolesController {

	@Autowired
    private ControllerFactory<RolesDto> controllerFactory;
	@Autowired
	private RolesBusiness rolesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolesDto> create(@RequestBody Request<RolesDto> request) {
    	// System.out.println("start method /roles/create");
        Response<RolesDto> response = controllerFactory.create(rolesBusiness, request, FunctionalityEnum.CREATE_ROLES);
		// System.out.println("end method /roles/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolesDto> update(@RequestBody Request<RolesDto> request) {
    	// System.out.println("start method /roles/update");
        Response<RolesDto> response = controllerFactory.update(rolesBusiness, request, FunctionalityEnum.UPDATE_ROLES);
		// System.out.println("end method /roles/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolesDto> delete(@RequestBody Request<RolesDto> request) {
    	// System.out.println("start method /roles/delete");
        Response<RolesDto> response = controllerFactory.delete(rolesBusiness, request, FunctionalityEnum.DELETE_ROLES);
		// System.out.println("end method /roles/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolesDto> getByCriteria(@RequestBody Request<RolesDto> request) {
    	// System.out.println("start method /roles/getByCriteria");
        Response<RolesDto> response = controllerFactory.getByCriteria(rolesBusiness, request, FunctionalityEnum.VIEW_ROLES);
		// System.out.println("end method /roles/getByCriteria");
        return response;
    }
}
