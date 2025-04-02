

/*
 * Java controller for entity table ordonnance_medicament 
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
Controller for table "ordonnance_medicament"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/ordonnanceMedicament")
public class OrdonnanceMedicamentController {

	@Autowired
    private ControllerFactory<OrdonnanceMedicamentDto> controllerFactory;
	@Autowired
	private OrdonnanceMedicamentBusiness ordonnanceMedicamentBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceMedicamentDto> create(@RequestBody Request<OrdonnanceMedicamentDto> request) {
    	// System.out.println("start method /ordonnanceMedicament/create");
        Response<OrdonnanceMedicamentDto> response = controllerFactory.create(ordonnanceMedicamentBusiness, request, FunctionalityEnum.CREATE_ORDONNANCE_MEDICAMENT);
		// System.out.println("end method /ordonnanceMedicament/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceMedicamentDto> update(@RequestBody Request<OrdonnanceMedicamentDto> request) {
    	// System.out.println("start method /ordonnanceMedicament/update");
        Response<OrdonnanceMedicamentDto> response = controllerFactory.update(ordonnanceMedicamentBusiness, request, FunctionalityEnum.UPDATE_ORDONNANCE_MEDICAMENT);
		// System.out.println("end method /ordonnanceMedicament/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceMedicamentDto> delete(@RequestBody Request<OrdonnanceMedicamentDto> request) {
    	// System.out.println("start method /ordonnanceMedicament/delete");
        Response<OrdonnanceMedicamentDto> response = controllerFactory.delete(ordonnanceMedicamentBusiness, request, FunctionalityEnum.DELETE_ORDONNANCE_MEDICAMENT);
		// System.out.println("end method /ordonnanceMedicament/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrdonnanceMedicamentDto> getByCriteria(@RequestBody Request<OrdonnanceMedicamentDto> request) {
    	// System.out.println("start method /ordonnanceMedicament/getByCriteria");
        Response<OrdonnanceMedicamentDto> response = controllerFactory.getByCriteria(ordonnanceMedicamentBusiness, request, FunctionalityEnum.VIEW_ORDONNANCE_MEDICAMENT);
		// System.out.println("end method /ordonnanceMedicament/getByCriteria");
        return response;
    }
}
