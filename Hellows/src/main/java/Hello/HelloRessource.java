package Hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("Greetings")
public class HelloRessource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
public String SayHello()
{
	return "Hello from jaxRS" ; 
}
	
	@GET
	@Path("{FirstName}/{LastName}")
	@Produces(MediaType.TEXT_PLAIN)
	
	
public String SayHelloTo(@PathParam(value = "FirstName") String FirstName , @PathParam(value = "LastName") String LastName)
{
	return "Hello from JaxRS " + FirstName + " " + LastName +" " ;
	
}
	
	@GET
	@Path("m3")
	@Produces(MediaType.TEXT_PLAIN)
	
public String SayHelloTo2(@QueryParam(value = "FirstName") String FirstName , @QueryParam(value = "LastName") String LastName)
{
	return "Hello from JaxRS " + FirstName + " " + LastName +" " ;
	
}
	
	











}
