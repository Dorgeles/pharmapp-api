

/*
 * Java controller for entity table medicament 
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
Controller for table "medicament"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/medicament")
public class MedicamentController {

	@Autowired
    private ControllerFactory<MedicamentDto> controllerFactory;
	@Autowired
	private MedicamentBusiness medicamentBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MedicamentDto> create(@RequestBody Request<MedicamentDto> request) {
    	// System.out.println("start method /medicament/create");
        Response<MedicamentDto> response = controllerFactory.create(medicamentBusiness, request, FunctionalityEnum.CREATE_MEDICAMENT);
		// System.out.println("end method /medicament/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MedicamentDto> update(@RequestBody Request<MedicamentDto> request) {
    	// System.out.println("start method /medicament/update");
        Response<MedicamentDto> response = controllerFactory.update(medicamentBusiness, request, FunctionalityEnum.UPDATE_MEDICAMENT);
		// System.out.println("end method /medicament/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MedicamentDto> delete(@RequestBody Request<MedicamentDto> request) {
    	// System.out.println("start method /medicament/delete");
        Response<MedicamentDto> response = controllerFactory.delete(medicamentBusiness, request, FunctionalityEnum.DELETE_MEDICAMENT);
		// System.out.println("end method /medicament/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MedicamentDto> getByCriteria(@RequestBody Request<MedicamentDto> request) {
    	// System.out.println("start method /medicament/getByCriteria");
        Response<MedicamentDto> response = controllerFactory.getByCriteria(medicamentBusiness, request, FunctionalityEnum.VIEW_MEDICAMENT);
		// System.out.println("end method /medicament/getByCriteria");
        return response;
    }
}
