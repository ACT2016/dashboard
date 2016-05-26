package com.acceture.lkm.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christophe Coenraets
 */
@XmlRootElement
public class Request {
	
	private String flowStepId = "";
	private String stepId = "";
	private String apiNumber = "";
	private String apiName = "";
	private String apiUrl = "";
	private String apiDescription = "";
	private String apiRequestType = "";
	private String jsonName = "";
	private String jsonUrl = "";
	private String jsonRequestType = "";
	private String jsonDescription = "";
	private String imageName = "";

	public String getFlowStepId() {
		return flowStepId;
	}
	public void setFlowStepId(String flowStepId) {
		this.flowStepId = flowStepId;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getApiNumber() {
		return apiNumber;
	}
	public void setApiNumber(String apiNumber) {
		this.apiNumber = apiNumber;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	public String getApiDescription() {
		return apiDescription;
	}
	public void setApiDescription(String apiDescription) {
		this.apiDescription = apiDescription;
	}
	public String getApiRequestType() {
		return apiRequestType;
	}
	public void setApiRequestType(String apiRequestType) {
		this.apiRequestType = apiRequestType;
	}
	public String getJsonName() {
		return jsonName;
	}
	public void setJsonName(String jsonName) {
		this.jsonName = jsonName;
	}
	public String getJsonUrl() {
		return jsonUrl;
	}
	public void setJsonUrl(String jsonUrl) {
		this.jsonUrl = jsonUrl;
	}
	public String getJsonRequestType() {
		return jsonRequestType;
	}
	public void setJsonRequestType(String jsonRequestType) {
		this.jsonRequestType = jsonRequestType;
	}
	public String getJsonDescription() {
		return jsonDescription;
	}
	public void setJsonDescription(String jsonDescription) {
		this.jsonDescription = jsonDescription;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	

}
