

/*
 * Java controller for entity table ordonnance 
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

/**
Controller for table "ordonnance"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/ordonnance")
public class OrdonnanceController {

	@Autowired
    private ControllerFactory<OrdonnanceDto> controllerFactory;
	@Autowired
	private OrdonnanceBusiness ordonnanceBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceDto> create(@RequestBody Request<OrdonnanceDto> request) {
    	// System.out.println("start method /ordonnance/create");
        Response<OrdonnanceDto> response = controllerFactory.create(ordonnanceBusiness, request, FunctionalityEnum.CREATE_ORDONNANCE);
		// System.out.println("end method /ordonnance/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceDto> update(@RequestBody Request<OrdonnanceDto> request) {
    	// System.out.println("start method /ordonnance/update");
        Response<OrdonnanceDto> response = controllerFactory.update(ordonnanceBusiness, request, FunctionalityEnum.UPDATE_ORDONNANCE);
		// System.out.println("end method /ordonnance/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceDto> delete(@RequestBody Request<OrdonnanceDto> request) {
    	// System.out.println("start method /ordonnance/delete");
        Response<OrdonnanceDto> response = controllerFactory.delete(ordonnanceBusiness, request, FunctionalityEnum.DELETE_ORDONNANCE);
		// System.out.println("end method /ordonnance/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceDto> getByCriteria(@RequestBody Request<OrdonnanceDto> request) {
    	// System.out.println("start method /ordonnance/getByCriteria");
        Response<OrdonnanceDto> response = controllerFactory.getByCriteria(ordonnanceBusiness, request, FunctionalityEnum.VIEW_ORDONNANCE);
		// System.out.println("end method /ordonnance/getByCriteria");
        return response;
    }
}
