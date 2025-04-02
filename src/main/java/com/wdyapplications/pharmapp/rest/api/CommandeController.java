

/*
 * Java controller for entity table commande 
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
Controller for table "commande"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/commande")
public class CommandeController {

	@Autowired
    private ControllerFactory<CommandeDto> controllerFactory;
	@Autowired
	private CommandeBusiness commandeBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandeDto> create(@RequestBody Request<CommandeDto> request) {
    	// System.out.println("start method /commande/create");
        Response<CommandeDto> response = controllerFactory.create(commandeBusiness, request, FunctionalityEnum.CREATE_COMMANDE);
		// System.out.println("end method /commande/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandeDto> update(@RequestBody Request<CommandeDto> request) {
    	// System.out.println("start method /commande/update");
        Response<CommandeDto> response = controllerFactory.update(commandeBusiness, request, FunctionalityEnum.UPDATE_COMMANDE);
		// System.out.println("end method /commande/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandeDto> delete(@RequestBody Request<CommandeDto> request) {
    	// System.out.println("start method /commande/delete");
        Response<CommandeDto> response = controllerFactory.delete(commandeBusiness, request, FunctionalityEnum.DELETE_COMMANDE);
		// System.out.println("end method /commande/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandeDto> getByCriteria(@RequestBody Request<CommandeDto> request) {
    	// System.out.println("start method /commande/getByCriteria");
        Response<CommandeDto> response = controllerFactory.getByCriteria(commandeBusiness, request, FunctionalityEnum.VIEW_COMMANDE);
		// System.out.println("end method /commande/getByCriteria");
        return response;
    }
}
