package com.webservice.controllers;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.beans.FeatureRequestBody;
import com.webservice.beans.FeatureResponseBody;
import com.webservice.controllers.entityRepository.FeatureRequestRepository;
import com.webservice.entities.FeatureRequest;
import com.webservice.service.FeatureRequestService;


//@RequestMapping("/user")
//@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class FeatureRequestController {
	
	@Autowired
	private FeatureRequestService featureRequest;
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	@RequestMapping(method = RequestMethod.POST, value="/api/feature")
	@ResponseBody
	public FeatureResponseBody featureRequestSave(@RequestBody FeatureRequest fr) {	
		FeatureResponseBody fRB = new FeatureResponseBody();
		try {
			List<FeatureRequest> frList = featureRepo.findAllRequestsByClient(fr.getClient());				
			boolean flag = false;
			Collections.sort((List<FeatureRequest>) frList);
			if(!frList.isEmpty()) {
				for(FeatureRequest f : frList){
					if(f.getClientPriority()!=0 && f.getClientPriority()==(fr.getClientPriority()) && !flag) {
						flag = true;
					}
					if(flag) {
						f.setClientPriority(f.getClientPriority() + 1);
					}
				}
				for(FeatureRequest f : frList){
					featureRepo.updateClientPriorityById(f.getId(), f.getClientPriority());
				}
			}
			featureRequest.save(fr);
			fRB.setFeatureRequest(fr);	
			fRB.setSuccess(true);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while saving the Feature Request");
			fRB.setSuccess(false);
			return fRB;
		}		
		return fRB;	
	}
}
