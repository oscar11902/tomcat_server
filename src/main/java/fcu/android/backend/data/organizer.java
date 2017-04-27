package fcu.android.backend.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class organizer implements Serializable {
	private int OID;

	private String organizerAccount;

	private String organizerName;

	private String principal;

	private String password;

	private String email;

	private String phone;

	public String getOranizerAccount() {
		return organizerAccount;
	}

	public void setOrganizerAccount(String organizerAccount) {
		this.organizerAccount = organizerAccount;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
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

	public int getOID() {
		return OID;
	}

	public void setOID(int oID) {
		OID = oID;
	}

	public String getOrganizerAccount() {
		return organizerAccount;
	}

}
