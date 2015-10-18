package test.britttonn.gsdemo.jaxrs;


import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter; 

public class GSDemoSecFilter implements ContainerRequestFilter {

	@Override
	public ContainerRequest filter(ContainerRequest arg0) {
		System.out.println("Doing filter");
		return arg0;
	}

}
