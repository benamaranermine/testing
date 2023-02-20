package rest.ressources;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import rest.entities.Employe;

	@Path("employes")
public class GestionEmploye {
	
	public static  List<Employe> employes=new ArrayList<Employe>();
		@POST
		@Consumes(MediaType.APPLICATION_XML) //@Consumes("application/xml")
		@Produces(MediaType.TEXT_PLAIN)
	public String ajouterEmploye(Employe employe) {
		 if(employes.add(employe))
	 return "Add Successful";
		return "Echec";
	}
		@GET
		@Produces(MediaType.APPLICATION_XML)
	public  List<Employe>  displayEmployeesList() {
		
				return employes;
	}
	
			@GET
			@Path("{cin}")
			@Produces(MediaType.APPLICATION_XML)
	public Response getEmploye(@PathParam("cin") int cin) {
		for (Employe info:employes) {
	       if(info.getCin()==cin) {
	    	   return  Response.status(Status.FOUND)
						.entity(info)
						.build(); 
	    	
	       }
		}
	       		
			return  Response.status(Status.NOT_FOUND).build();
		
		
	}
	
		
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	
	}
	
	@DELETE
	@Path("{cin}")
	public boolean deleteEmpl(@PathParam("cin") int cin){
		int index= getIndexByCin(cin);
		
		if (index!=-1) {
			employes.remove(index);
			return true;
		}else 
			return false;
			
    }
	
	public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
	
		
}
