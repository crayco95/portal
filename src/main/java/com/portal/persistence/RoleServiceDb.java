package com.portal.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portal.dao.RoleMapper;
import com.portal.model.Role;

@Component
public class RoleServiceDb {
	@Autowired
	private RoleMapper roleMapper;

	public List<Role> getRoleByUserid(int userid) {
		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		parametrosInOout.put("p_user_id", userid);
		roleMapper.getRoleByUseridDB(parametrosInOout);
		List<Role> roles = null;
		String codigoRespuesta = (String) parametrosInOout.get("p_cod_rpta");
		if(codigoRespuesta != null && codigoRespuesta.equals("OK")) {
			
			try {
				roles = (List<Role>) parametrosInOout.get("p_role");
			} catch (Exception e) {
				roles = null;
			}
		
		}else {
			roles = null;
		}
		
		return roles;
	}
}
