package com.portal.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.portal.security.UserSpringGrant;
import com.portal.dao.UserMapper;
import com.portal.model.Role;
import com.portal.model.User;
import com.portal.persistence.RoleServiceDb;

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userRepository;
	@Autowired
	private RoleServiceDb roleServiceDb;

	// Verificacion de inicio de sesión

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		UserSpring userSpring = null;

		userSpring = new UserSpring();

		userSpring.setActive(1);

		userSpring.setId(1);

		userSpring.setUserName(user.getUsername());
		userSpring.setPassword(user.getPassword());

		// Autorizacion por roles
		//Los nombres de los roles deben comenzar con el prefijo: "ROLE_"
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// Obtener lista de permisos basa en nombre de usuario
		List<Role> roles = roleServiceDb.getRoleByUserid(user.getId());
		for (Role role : roles) {
			user.setRoles(roles);
			authorities.add(new UserSpringGrant(role.getRolname()));
		}

		userSpring.setRoles(authorities);

		return new UserDetailsSpring(userSpring);

	}

}
