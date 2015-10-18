package test.brittonn.mvcpract.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import test.brittonn.hibpract.IFacesDao;
import test.brittonn.hibpract.model.Risk;

@Path("risk")
public class RiskService {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response storeRisk(Risk risk) {
		IFacesDao.getInstance().addRisk(risk);
		System.out.println(risk.getName());
		risk.setName(risk.getName()+" : processed");
		return Response.ok(risk).status(200).build();
	}

}
