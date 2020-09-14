package com.webservice.beans;

import java.util.List;

import com.webservice.entities.FeatureRequest;

public class FeatureRequestBody {
	
	private List<FeatureRequest> featureRequest;
	
	private Boolean success;
	
//	private St

	public List<FeatureRequest> getFeatureRequest() {
		return featureRequest;
	}

	public void setFeatureRequest(List<FeatureRequest> featureRequest) {
		this.featureRequest = featureRequest;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
	
}
