package com.acceture.lkm.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christophe Coenraets
 */
@XmlRootElement
public class Request {
	
	private String flowStepId = "";
	private String stepId = "";
	private String sequence = "";
	private String method = "";
	private String responeCode = "";	
	private String apiUrl = "";
	
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
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getResponeCode() {
		return responeCode;
	}
	public void setResponeCode(String responeCode) {
		this.responeCode = responeCode;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

}
