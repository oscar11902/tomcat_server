	package fcu.android.backend.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fcu.android.backend.data.seminar;
import fcu.android.backend.db.DatabaseManager;

@Path("seminar/")
public class SeminarService 
{

  private DatabaseManager dbManager = DatabaseManager.getInstance();

  @POST
  @Path("register")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String register(@FormParam("name") String name,@FormParam("startDate") String startDate,
		  			   @FormParam("endDate") String endDate,@FormParam("location") String location,
		  			   @FormParam("introduction") String introduction) 
  {
	boolean regist=false;
	seminar seminar = new seminar();
	seminar.setName(name);
	seminar.setStartDate(startDate);
	seminar.setEndDate(endDate);
	seminar.setLocation(location);
	seminar.setIntroduction(introduction);
    regist = dbManager.addSeminar(seminar);
    return String.valueOf(regist);
  }
  
  @GET
  @Path("{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public seminar getSeminar(@PathParam("name") String name)
  {
    return dbManager.getSeminar(name);
  }
  
  @GET
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  public List<seminar> listSeminars() 
  {
    return dbManager.listAllSeminars();
  }
  

}
