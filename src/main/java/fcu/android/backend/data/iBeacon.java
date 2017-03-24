package fcu.android.backend.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class iBeacon implements Serializable{	
  private String uuid;
	
  private String major;
  
  private String minor;
  
  public String getUuid() {
	    return uuid;
	  }

  public void setUuid(String uuid) {
	    this.uuid = uuid;
	  }
  
  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }
  
  public String getMinor() {
	    return minor;
	  }

	  public void setMinor(String minor) {
	    this.minor = minor;
	  }

}
