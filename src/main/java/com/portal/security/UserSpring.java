package com.portal.security;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;


public class UserSpring  {
	private Integer id;
	private String password;
	private String passwordConfirm;
    private String loginId;
	private String userName;
	private Integer active;
	private List<GrantedAuthority> roles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public List<GrantedAuthority> getRoles() {
		return roles;
	}
	public void setRoles(List<GrantedAuthority> authorities) {
		this.roles = authorities;
	}
	

	
}