package springmember.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("member")
public class Member implements Serializable{
	
	private static final long serialVersionUID = 4874865132165L;
	
	private String mid;
	private String mname;
	private String mgender;
	private String mcity;
	
	public Member() {
	}

	public Member(String mid, String mname, String mgender, String mcity) {
		this.mid = mid;
		this.mname = mname;
		this.mgender = mgender;
		this.mcity = mcity;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMgender() {
		return mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMcity() {
		return mcity;
	}

	public void setMcity(String mcity) {
		this.mcity = mcity;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mname=" + mname + ", mgender=" + mgender + ", mcity=" + mcity + "]";
	}
	
	
	
	

}
