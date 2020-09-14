package com.webservice.controllers;

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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class FeatureRequestDeleteController {
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	@RequestMapping(method = RequestMethod.DELETE, value="/api/feature/{id}")
	@ResponseBody
	public FeatureResponseBody deleteFeatureRequest(@PathVariable long id) {
		FeatureResponseBody fRB = new FeatureResponseBody();
		try {
			featureRepo.deleteFeatureRequestById(id);
			fRB.setSuccess(true);
		}catch(Exception ex) {
			ex.printStackTrace();
			fRB.setSuccess(false);
			return fRB;
		}
		return fRB;
	}

}
