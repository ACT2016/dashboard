package com.acceture.lkm.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christophe Coenraets
 */
@XmlRootElement
public class Step {

	private String stepId="";
	private String flowId="";
	private String stepName="";
	private String stepDescription="";
	private String expectedResult="";
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getStepDescription() {
		return stepDescription;
	}
	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}


}
