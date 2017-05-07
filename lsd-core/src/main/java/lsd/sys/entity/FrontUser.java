package lsd.sys.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lsd.common.entity.BaseEntity;

@Entity
@Table(name = "t_front_user")
public class FrontUser extends BaseEntity<Long> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 163776702555341117L;
	private String name;
	private String username;
	private String password;
	private String email;
	private String tel;
	private String sex;
	private String grade;
	private String address;
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
