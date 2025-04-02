

/*
 * Java controller for entity table prix_medicament 
 * Created on 2024-12-01 ( Time 21:32:06 )
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
Controller for table "prix_medicament"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/prixMedicament")
public class PrixMedicamentController {

	@Autowired
    private ControllerFactory<PrixMedicamentDto> controllerFactory;
	@Autowired
	private PrixMedicamentBusiness prixMedicamentBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrixMedicamentDto> create(@RequestBody Request<PrixMedicamentDto> request) {
    	// System.out.println("start method /prixMedicament/create");
        Response<PrixMedicamentDto> response = controllerFactory.create(prixMedicamentBusiness, request, FunctionalityEnum.CREATE_PRIX_MEDICAMENT);
		// System.out.println("end method /prixMedicament/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrixMedicamentDto> update(@RequestBody Request<PrixMedicamentDto> request) {
    	// System.out.println("start method /prixMedicament/update");
        Response<PrixMedicamentDto> response = controllerFactory.update(prixMedicamentBusiness, request, FunctionalityEnum.UPDATE_PRIX_MEDICAMENT);
		// System.out.println("end method /prixMedicament/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrixMedicamentDto> delete(@RequestBody Request<PrixMedicamentDto> request) {
    	// System.out.println("start method /prixMedicament/delete");
        Response<PrixMedicamentDto> response = controllerFactory.delete(prixMedicamentBusiness, request, FunctionalityEnum.DELETE_PRIX_MEDICAMENT);
		// System.out.println("end method /prixMedicament/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrixMedicamentDto> getByCriteria(@RequestBody Request<PrixMedicamentDto> request) {
    	// System.out.println("start method /prixMedicament/getByCriteria");
        Response<PrixMedicamentDto> response = controllerFactory.getByCriteria(prixMedicamentBusiness, request, FunctionalityEnum.VIEW_PRIX_MEDICAMENT);
		// System.out.println("end method /prixMedicament/getByCriteria");
        return response;
    }
}
