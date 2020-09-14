package com.webservice.beans;

import com.webservice.entities.FeatureRequest;

public class FeatureResponseBody {
	
	private FeatureRequest featureRequest;
	
	private Boolean success;

	public FeatureRequest getFeatureRequest() {
		return featureRequest;
	}

	public void setFeatureRequest(FeatureRequest featureRequest) {
		this.featureRequest = featureRequest;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
