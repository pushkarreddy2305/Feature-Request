package com.webservice.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeatureRequest implements Serializable,Comparable<FeatureRequest> {
	
	private static final long serialVersionUID = 10084510L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(columnDefinition = "title")
	private String title;
	
	@Column(columnDefinition = "description")
	private String description;
	
	@Column(columnDefinition = "client")
	private String client;
	
	@Column(columnDefinition = "client_priority")
	private int clientPriority;
	
	@Column(columnDefinition = "target_date")
	private String targetDate;
	
	@Column(columnDefinition = "product_area")
	private String productArea;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getClientPriority() {
		return clientPriority;
	}
	public void setClientPriority(int clientPriority) {
		this.clientPriority = clientPriority;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getProductArea() {
		return productArea;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	@Override
	public String toString() {
		return "FeatureRequest [id=" + id + ", title=" + title +", description=" + description +",client=" 
				+ client +", clientPriority=" + clientPriority +", targetDate=" + targetDate +",productArea="
				+ productArea	+"]";
	}
	
	public int compareTo(FeatureRequest fr) {
		int comparePriority = ((FeatureRequest) fr).getClientPriority();
		return this.clientPriority-comparePriority;
	}

}
