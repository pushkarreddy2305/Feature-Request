package com.webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webservice.beans.FeatureResponseBody;
import com.webservice.controllers.entityRepository.FeatureRequestRepository;
import com.webservice.entities.FeatureRequest;
import com.webservice.service.FeatureRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class FeatureRequestUpdateController {
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value="/api/feature/update")
	public FeatureResponseBody featureRequestUpdate(@RequestBody FeatureRequest fr) {	
		FeatureResponseBody fRB = new FeatureResponseBody();
		try {
			featureRepo.updateFeatureRequest(fr.getId(), fr.getClientPriority(), fr.getTitle(), fr.getDescription(), fr.getClient(), fr.getTargetDate(), fr.getProductArea());
			fRB.setFeatureRequest(fr);
			fRB.setSuccess(true);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			fRB.setSuccess(false);
		}
		
		return fRB;

	}
}
