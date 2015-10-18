package test.britttonn.gsdemo.jaxrs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import test.britttonn.gsdemo.GSDemoException;

@Provider
public class ExceptionHttpStatusResolver implements ExceptionMapper<Exception> {

	// @Override
	// public Response toResponse(GSDemoException exception) {
	// Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
	//
	// if (exception instanceof GSDemoException)
	// httpStatus = Response.Status.BAD_REQUEST;
	//
	// return Response.status(httpStatus).entity(exception.getMessage())
	// .build();
	// }

	@Override
	public Response toResponse(Exception arg0) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;

		if (arg0 instanceof GSDemoException)
			httpStatus = Response.Status.BAD_REQUEST;

		return Response.status(httpStatus).entity(arg0.getMessage()).build();
	}
}
