package com.portal.persistence;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portal.dao.RoleMapper;
import com.portal.model.Role;

@Component
public class RoleServiceDb {
	@Autowired
	private RoleMapper roleMapper;

	public Role getRoleByUserid(int userid) {
		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		parametrosInOout.put("p_user_id", userid);
		roleMapper.getRoleByUseridDB(parametrosInOout);
		Role role;
		String codigoRespuesta = (String) parametrosInOout.get("p_cod_rpta");
		if(codigoRespuesta != null && codigoRespuesta.equals("OK")) {
			String roleId = (String) parametrosInOout.get("p_rol_id");
			String roleName = (String) parametrosInOout.get("p_rol_name");
			role = new Role();
			role.setId(Integer.parseInt(roleId));
			role.setName(roleName);
		}else {
			role = null;
		}
		
		return role;
	}
}
