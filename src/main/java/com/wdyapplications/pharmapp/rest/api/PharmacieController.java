

/*
 * Java controller for entity table pharmacie 
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
Controller for table "pharmacie"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/pharmacie")
public class PharmacieController {

	@Autowired
    private ControllerFactory<PharmacieDto> controllerFactory;
	@Autowired
	private PharmacieBusiness pharmacieBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacieDto> create(@RequestBody Request<PharmacieDto> request) {
    	// System.out.println("start method /pharmacie/create");
        Response<PharmacieDto> response = controllerFactory.create(pharmacieBusiness, request, FunctionalityEnum.CREATE_PHARMACIE);
		// System.out.println("end method /pharmacie/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacieDto> update(@RequestBody Request<PharmacieDto> request) {
    	// System.out.println("start method /pharmacie/update");
        Response<PharmacieDto> response = controllerFactory.update(pharmacieBusiness, request, FunctionalityEnum.UPDATE_PHARMACIE);
		// System.out.println("end method /pharmacie/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacieDto> delete(@RequestBody Request<PharmacieDto> request) {
    	// System.out.println("start method /pharmacie/delete");
        Response<PharmacieDto> response = controllerFactory.delete(pharmacieBusiness, request, FunctionalityEnum.DELETE_PHARMACIE);
		// System.out.println("end method /pharmacie/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacieDto> getByCriteria(@RequestBody Request<PharmacieDto> request) {
    	// System.out.println("start method /pharmacie/getByCriteria");
        Response<PharmacieDto> response = controllerFactory.getByCriteria(pharmacieBusiness, request, FunctionalityEnum.VIEW_PHARMACIE);
		// System.out.println("end method /pharmacie/getByCriteria");
        return response;
    }
}
