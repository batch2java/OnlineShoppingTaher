package com.cg.onlineshopping.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class User {
	
	
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    //@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
	private Integer userId;
    @NotEmpty(message="password should not empty")
	private String password;
    @NotEmpty(message="role should not empty")
	private String role;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
}
