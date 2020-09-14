package com.webservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webservice.beans.FeatureRequestBody;
import com.webservice.beans.FeatureResponseBody;
import com.webservice.controllers.entityRepository.FeatureRequestRepository;
import com.webservice.entities.FeatureRequest;
import com.webservice.service.FeatureRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class FeatureRequestSearchController {
	
	@Autowired
	private FeatureRequestService featureRequest;
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	@RequestMapping(method = RequestMethod.GET, value="/api/features")
	@ResponseBody
	public FeatureRequestBody getFeatureRequests () {      //(@RequestBody FeatureRequest fr){
		FeatureRequestBody fRB = new FeatureRequestBody();
		List <FeatureRequest> frList = new ArrayList<FeatureRequest>();
		try {
			frList = featureRepo.findAllRequests();
			fRB.setFeatureRequest(frList);
			fRB.setSuccess(true);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while searching");
			FeatureRequest frr = new FeatureRequest();
			fRB.setSuccess(false);	
		}		
		return fRB;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/api/feature/{id}")
	@ResponseBody
	public FeatureResponseBody getFeatureRequestbyId(@PathVariable long id){
		FeatureResponseBody fRB = new FeatureResponseBody();
		FeatureRequest freq = new FeatureRequest();
		try {
			freq = featureRepo.findAllRequestsById(id);
			fRB.setFeatureRequest(freq);
			fRB.setSuccess(true);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while searching");
			fRB.setSuccess(false);	
		}		
		return fRB;
	}

}
