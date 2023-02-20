package WS;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.Employee;

@Path("employees")


public class EmployeeResource {
	static List<Employee> Employees = new ArrayList<Employee>();

	@POST 
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.TEXT_PLAIN)
	public String AddEmployee(Employee e)
	{
		if(Employees.add(e))
			return ("Add successful");
		else 
			return ("Add unsuccessful");
	}
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
			public List<Employee> DisplayList()
	{
		if(Employees==null)
			return null ;
		else
			return
					Employees;
	}
	
	@PUT
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.TEXT_PLAIN)
	public String UpdateEmployee(Employee e)
	{
		int index = GetIndexByCIN(e.getCin());
		if(index != -1)
		{
			 Employees.set(index, e);
				return "Update successful";
		}
			
	      else 
			return ("Update unsuccessful");
		
	}
	
	public int GetIndexByCIN(String cin)
	{
		for(Employee E : Employees)
		{
			if(E.getCin().equals(cin))
				return Employees.indexOf(E);
		}
		return -1;
	}
	
	@GET
	@Path("{cin}")
	@Produces (MediaType.APPLICATION_JSON)
	public Employee SearchEmployee(@PathParam("cin") String cin)
	{
		int index = GetIndexByCIN(cin);
		if(index != -1)
			return Employees.get(index);
		else 
			return null ;
	}
	
	@DELETE
	@Path("{cin}")
	@Produces (MediaType.TEXT_PLAIN)
	public String DeleteEmployee(@PathParam("cin") String cin)
	{
		int index = GetIndexByCIN(cin);
		if(index != -1)
		{
			Employees.remove(index);
			return "true" ; 
		}
		else 
			return "false";
		
		
	}

}
