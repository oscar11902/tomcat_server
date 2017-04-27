package fcu.android.backend.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class iBeacon implements Serializable {

	private int BID, SID, OID;

	public iBeacon(int sID, int oID, String uuid, String major, String minor, String local) {
		super();
		SID = sID;
		OID = oID;
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.local = local;
	}

	public iBeacon() {
		super();
	}

	public iBeacon(int bID, int sID, int oID, String uuid, String major, String minor, String local) {
		super();
		BID = bID;
		SID = sID;
		OID = oID;
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.local = local;
	}

	private String uuid;

	private String major;

	private String minor;

	private String local;

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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
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
