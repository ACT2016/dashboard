package com.accenture.lkm.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accenture.lkm.dao.StepDAO;
import com.acceture.lkm.beans.Step;

@Path("/step")
public class StepResource {

	StepDAO dao = new StepDAO();


	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Step> findById(@PathParam("id") String id) {
		return dao.findStepsByName(id);
	}
	
}
