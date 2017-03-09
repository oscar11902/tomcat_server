package fcu.android.backend.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
  
  private String userAccount;
  
  private String userName;
  
  private String password;
  
  private String email;
  
  private String phone;

  public String getUseraccount() {
	    return userAccount;
	  }
  
  public void setUserAccount(String userAccount) {
	    this.userAccount = userAccount;
	  }
  
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPhone() {
	    return phone;
	  }
  
  public void setPhone(String phone) {
	    this.phone = phone;
	  }

}
