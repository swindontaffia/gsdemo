package com.pallelli.mvcpract.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pallelli.hibpract.policymodel.PolicyDaoImpl;
import com.pallelli.hibpract.policymodel.beans.Risk;

//@Configurable
//@Service("riskService")
@Path("risk")
@Component
public class RiskService {
	
	@Autowired
	private PolicyDaoImpl policyDao;
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response storeRisk(Risk risk) {
		
		policyDao.addRisk(risk);
		System.out.println(risk.getName());
		risk.setName(risk.getName()+" : processed");
		return Response.ok(risk).status(200).build();
	}
}	

