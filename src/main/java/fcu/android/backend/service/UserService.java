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

import fcu.android.backend.data.User;
import fcu.android.backend.db.DatabaseManager;

@Path("user/")
public class UserService 
{

  private DatabaseManager dbManager = DatabaseManager.getInstance();

  @POST
  @Path("register")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String register(@FormParam("userAccount") String userAccount,@FormParam("userName") String userName,
		  			   @FormParam("password") String password,@FormParam("email") String email,@FormParam("phone") String phone) 
  {
	boolean regist=false;
    User user = new User();
    user.setUserAccount(userAccount);
    user.setUserName(userName);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(phone);    
    regist = dbManager.addUser(user);
    return String.valueOf(regist);
  }
  
  
  
  @POST
  @Path("login")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String login(@FormParam("userAccount") String userAccount,@FormParam("password") String password) 
  {
    User user = new User();
    user.setUserAccount(userAccount);
    user.setPassword(password);
    
    boolean login = dbManager.loginUser(userAccount, password);
    return String.valueOf(login);
  }

  @POST
  @Path("validate")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public String isValidUser(@FormParam("email") String email, @FormParam("password") String password) 
  {
    boolean valid = dbManager.validateUser(email, password);
    return String.valueOf(valid);
  }

  @GET
  @Path("{userAccount}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUser(@PathParam("userAccount") String userAccount)
  {
    return dbManager.getUser(userAccount);
  }

  @GET
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> listUsers() 
  {
    return dbManager.listAllUsers();
  }

}
