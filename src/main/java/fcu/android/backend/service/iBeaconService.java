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

import fcu.android.backend.data.iBeacon;
import fcu.android.backend.db.DatabaseManager;

@Path("ibeacon/")
public class iBeaconService
{

  private DatabaseManager dbManager = DatabaseManager.getInstance();
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String echo() {
	  return "hello ibeacon";
  }
  
  
  @POST
  @Path("register")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public iBeacon register(@FormParam("uuid") String uuid, @FormParam("major") String major, @FormParam("minor") String minor,
		  				  @FormParam("location") String local)
  {
	iBeacon iBeacon = new iBeacon();
	iBeacon.setUuid(uuid);
	iBeacon.setMajor(major);
	iBeacon.setMinor(minor);
	iBeacon.setLocal(local);
	
    dbManager.addiBeacon(iBeacon);
    return iBeacon;
  }

  @POST
  @Path("cheakin")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String cheakin(@FormParam("uuid") String uuid,@FormParam("major") String major,
		  				@FormParam("minor") String minor)
  {
    iBeacon iBeacon = new iBeacon();
    iBeacon.setUuid(uuid);
    iBeacon.setMajor(major);
    iBeacon.setMinor(minor);
    boolean cheakin = dbManager.cheakiniBeacon(uuid, major, minor);
    return String.valueOf(cheakin);
  }
  

  @GET
  @Path("{uuid}")
  @Produces(MediaType.APPLICATION_JSON)
  public iBeacon getiBeacon(@PathParam("uuid") String uuid)
  {
    return dbManager.getiBeacon(uuid);
  }
  
  @GET
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  public List<iBeacon> listiBeacons()
  {
    return dbManager.listAlliBeacons();
  }
  
}
