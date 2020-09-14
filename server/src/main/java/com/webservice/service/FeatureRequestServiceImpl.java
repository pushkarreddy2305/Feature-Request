package com.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.controllers.entityRepository.FeatureRequestRepository;
import com.webservice.entities.FeatureRequest;


@Service
public class FeatureRequestServiceImpl implements FeatureRequestService{
	
	@Autowired
	private FeatureRequestRepository featureRepo;
	
	public FeatureRequest save(FeatureRequest fr) {
		featureRepo.save(fr);
		return fr;
	}

}
