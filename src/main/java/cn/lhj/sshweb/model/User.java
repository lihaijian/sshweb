package cn.lhj.sshweb.model;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private int id;
	
	@NotEmpty
	private String username;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@DecimalMax(value = "2.5")
	@DecimalMin(value = "1.0")
	private Double height;
	
	@NotNull
	private Department dpt;
	
	public User() {
		super();
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Department getDpt() {
		return dpt;
	}
	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", email=" + email + ", height="
				+ height + ", dpt=" + dpt + "]";
	}
	
	
	
	
}
