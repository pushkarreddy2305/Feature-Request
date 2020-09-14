package com.webservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webservice.entities.FeatureRequest;

public interface FeatureRequestService {
	
	public FeatureRequest save(FeatureRequest fr);

}
