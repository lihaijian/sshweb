package cn.lhj.sshweb.model;

import java.util.Date;

public class People {
	private int id;
	private String phoneNo;
	private String address;
	private Date regDate;
	private String username;
	private String passwd;
	
	public People() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", phoneNo=" + phoneNo + ", address=" + address + ", regDate=" + regDate
				+ ", username=" + username + ", passwd=" + passwd + "]";
	}
}
