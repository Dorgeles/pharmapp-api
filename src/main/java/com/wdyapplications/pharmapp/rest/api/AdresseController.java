

/*
 * Java controller for entity table adresse 
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
import com.wdyapplications.pharmapp.utils.redis.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
Controller for table "adresse"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/adresse")
public class AdresseController {

	@Autowired
    private ControllerFactory<AdresseDto> controllerFactory;
	@Autowired
	private AdresseBusiness adresseBusiness;
    @Autowired
    private CacheUtils redisRepository;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AdresseDto> create(@RequestBody Request<AdresseDto> request) {
    	// System.out.println("start method /adresse/create");
        Response<AdresseDto> response = controllerFactory.create(adresseBusiness, request, FunctionalityEnum.CREATE_ADRESSE);
		// System.out.println("end method /adresse/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AdresseDto> update(@RequestBody Request<AdresseDto> request) {
    	// System.out.println("start method /adresse/update");
        Response<AdresseDto> response = controllerFactory.update(adresseBusiness, request, FunctionalityEnum.UPDATE_ADRESSE);
		// System.out.println("end method /adresse/update");
        return response;
    }

    @RequestMapping(value="/try",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public String tryConnection(@RequestBody Map<String, String> request) {
    	// System.out.println("start method /adresse/try");
        redisRepository.cacheData("test", "test", 1);
        return "success";
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AdresseDto> delete(@RequestBody Request<AdresseDto> request) {
    	// System.out.println("start method /adresse/delete");
        Response<AdresseDto> response = controllerFactory.delete(adresseBusiness, request, FunctionalityEnum.DELETE_ADRESSE);
		// System.out.println("end method /adresse/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<AdresseDto> getByCriteria(@RequestBody Request<AdresseDto> request) {
    	// System.out.println("start method /adresse/getByCriteria");
        Response<AdresseDto> response = controllerFactory.getByCriteria(adresseBusiness, request, FunctionalityEnum.VIEW_ADRESSE);
		// System.out.println("end method /adresse/getByCriteria");
        return response;
    }
}
