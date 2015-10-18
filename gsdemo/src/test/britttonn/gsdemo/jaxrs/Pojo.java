package test.britttonn.gsdemo.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import test.britttonn.gsdemo.GSDemoException;

@Path("hello")
public class Pojo   
{

	@GET
	@Produces("text/plain")
	public String g1() {
		return "get 1 - hello";
	}
	
	@Path("{c}")
	@GET
	@Produces("text/plain")
	public String g2(@PathParam("c") int c) throws GSDemoException {
		if(c == 10) throw new GSDemoException();
		return "get " + c + " - hello";
	}

	
	@PUT
	@Produces("text/plain")
	public String p1() {
		return "put - hello 2";
	}

}
