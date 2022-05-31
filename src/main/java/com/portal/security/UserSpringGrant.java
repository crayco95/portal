package com.portal.security;

import org.springframework.security.core.GrantedAuthority;

public class UserSpringGrant implements GrantedAuthority {
    
	
	public static final String GRANT_AUTH_ADMIN	= "ROLE_ADMIN";
	public static final String GRANT_AUTH_USER 	= "ROLE_USER";
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	
    private String rol;
	public  UserSpringGrant(String rol) {
		this.rol = rol;
	}
	@Override
    public String getAuthority() {
        return rol;
    }
	
}
