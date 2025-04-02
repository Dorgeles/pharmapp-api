

/*
 * Java controller for entity table assurances 
 * Created on 2024-12-01 ( Time 21:32:04 )
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
Controller for table "assurances"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/assurances")
public class AssurancesController {

	@Autowired
    private ControllerFactory<AssurancesDto> controllerFactory;
	@Autowired
	private AssurancesBusiness assurancesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AssurancesDto> create(@RequestBody Request<AssurancesDto> request) {
    	// System.out.println("start method /assurances/create");
        Response<AssurancesDto> response = controllerFactory.create(assurancesBusiness, request, FunctionalityEnum.CREATE_ASSURANCES);
		// System.out.println("end method /assurances/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AssurancesDto> update(@RequestBody Request<AssurancesDto> request) {
    	// System.out.println("start method /assurances/update");
        Response<AssurancesDto> response = controllerFactory.update(assurancesBusiness, request, FunctionalityEnum.UPDATE_ASSURANCES);
		// System.out.println("end method /assurances/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AssurancesDto> delete(@RequestBody Request<AssurancesDto> request) {
    	// System.out.println("start method /assurances/delete");
        Response<AssurancesDto> response = controllerFactory.delete(assurancesBusiness, request, FunctionalityEnum.DELETE_ASSURANCES);
		// System.out.println("end method /assurances/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AssurancesDto> getByCriteria(@RequestBody Request<AssurancesDto> request) {
    	// System.out.println("start method /assurances/getByCriteria");
        Response<AssurancesDto> response = controllerFactory.getByCriteria(assurancesBusiness, request, FunctionalityEnum.VIEW_ASSURANCES);
		// System.out.println("end method /assurances/getByCriteria");
        return response;
    }
}
