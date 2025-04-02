

/*
 * Java controller for entity table user_roles 
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
Controller for table "user_roles"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/userRoles")
public class UserRolesController {

	@Autowired
    private ControllerFactory<UserRolesDto> controllerFactory;
	@Autowired
	private UserRolesBusiness userRolesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRolesDto> create(@RequestBody Request<UserRolesDto> request) {
    	// System.out.println("start method /userRoles/create");
        Response<UserRolesDto> response = controllerFactory.create(userRolesBusiness, request, FunctionalityEnum.CREATE_USER_ROLES);
		// System.out.println("end method /userRoles/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRolesDto> update(@RequestBody Request<UserRolesDto> request) {
    	// System.out.println("start method /userRoles/update");
        Response<UserRolesDto> response = controllerFactory.update(userRolesBusiness, request, FunctionalityEnum.UPDATE_USER_ROLES);
		// System.out.println("end method /userRoles/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRolesDto> delete(@RequestBody Request<UserRolesDto> request) {
    	// System.out.println("start method /userRoles/delete");
        Response<UserRolesDto> response = controllerFactory.delete(userRolesBusiness, request, FunctionalityEnum.DELETE_USER_ROLES);
		// System.out.println("end method /userRoles/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRolesDto> getByCriteria(@RequestBody Request<UserRolesDto> request) {
    	// System.out.println("start method /userRoles/getByCriteria");
        Response<UserRolesDto> response = controllerFactory.getByCriteria(userRolesBusiness, request, FunctionalityEnum.VIEW_USER_ROLES);
		// System.out.println("end method /userRoles/getByCriteria");
        return response;
    }
}
