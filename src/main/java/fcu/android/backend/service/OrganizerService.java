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

import fcu.android.backend.data.organizer;
import fcu.android.backend.db.DatabaseManager;

@Path("organizer/")
public class OrganizerService {

  private DatabaseManager dbManager = DatabaseManager.getInstance();

  @POST
  @Path("register")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public organizer register(@FormParam("organizerAccount") String organizerAccount,@FormParam("organizerName") String organizerName, @FormParam("password") String password,
      @FormParam("email") String email,@FormParam("phone") String phone,@FormParam("principal") String principal) {
    organizer organizer = new organizer();
    organizer.setOrganizerAccount(organizerAccount);
    organizer.setOrganizerName(organizerName);
    organizer.setPassword(password);
    organizer.setEmail(email);
    organizer.setPhone(phone);
    organizer.setPrincipal(principal);
    dbManager.addOrganizer(organizer);
    return organizer;
  }
  
  @POST
  @Path("login")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String login(@FormParam("organizerAccount") String organizerAccount,@FormParam("password") String password) {
    organizer organizer = new organizer();
    organizer.setOrganizerAccount(organizerAccount);
    organizer.setPassword(password);
    
    boolean login = dbManager.loginOrganizer(organizerAccount, password);
    return String.valueOf(login);
  }

  @POST
  @Path("validate")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String isValidOrganizer(@FormParam("email") String email, @FormParam("password") String password) {
    boolean valid = dbManager.validateOrganizer(email, password);
    return String.valueOf(valid);
  }

  @GET
  @Path("{email}")
  @Produces(MediaType.APPLICATION_JSON)
  public organizer getOrganizer(@PathParam("email") String email) {

    return dbManager.getOrganizer(email);
  }

  @GET
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  public List<organizer> listOrganizers() {
    return dbManager.listAllorganizer();
  }
  
 

}
