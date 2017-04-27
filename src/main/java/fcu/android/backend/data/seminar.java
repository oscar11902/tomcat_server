package fcu.android.backend.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class seminar implements Serializable {

	private int SID,OID;	
	
	private String name;

	private String startDate;

	private String endDate;

	private String location;

	private String introduction;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int getOID() {
		return OID;
	}

	public void setOID(int oID) {
		OID = oID;
	}

}
