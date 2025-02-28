package springaopex.model;

import java.io.Serializable;

public class Springaopex implements Serializable {

	private static final long serialVersionUID = 3298478329434L;

	private int sid;
	private String spass;

	public Springaopex() {
	}

	public Springaopex(int sid, String spass) {
		super();
		this.sid = sid;
		this.spass = spass;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSpass() {
		return spass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}

	@Override
	public String toString() {
		return "Springaopex [sid=" + sid + ", spass=" + spass + "]";
	}

}
