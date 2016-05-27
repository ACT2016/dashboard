package com.accenture.lkm.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.accenture.lkm.dao.RequestDAO;
import com.acceture.lkm.beans.Request;

@Path("/request")
public class RequestResource {

	RequestDAO dao = new RequestDAO();


	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	public List<Request> findById(@QueryParam("flowId") String flowId,@QueryParam("stepId") String stepId) {
		return dao.findByFlowStep(flowId, stepId);
	}
	
}
