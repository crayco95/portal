package com.portal.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.portal.dao.UserMapper;
import com.portal.model.Role;
import com.portal.model.User;
import com.portal.persistence.RoleServiceDb;

public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserMapper userRepository;
	@Autowired
	private RoleServiceDb roleServiceDb;
	//Verificacion de inicio de sesión
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("El nombre de usuario no existe");
		}
		//Autorizacion por roles
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		//Obtener lista de permisos basa en nombre de usuario
		Role role = roleServiceDb.getRoleByUserid(user.getId());
		
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

}
