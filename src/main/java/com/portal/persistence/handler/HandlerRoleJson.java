package com.portal.persistence.handler;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.postgresql.util.PGobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.portal.model.Role;

public class HandlerRoleJson extends BaseTypeHandler implements TypeHandler<Object>{
	Logger logger = LoggerFactory.getLogger(HandlerRoleJson.class);

	@Override
	public Object getResult(ResultSet arg0, String arg1) throws SQLException {
		try {
			
			Array value = arg0.getArray(arg1);
			logger.info(""+value);
		} catch (Exception e) {
			Object value = arg0.getObject(arg1);
			logger.info(""+value);
		}
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		List<Role> role = new ArrayList<>();
		
		String respuesta = null;
		try {
			respuesta = (String) cs.getString(columnIndex);
		} catch (Exception e) {
			respuesta = null;
		}
		if (respuesta != null) {
			
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				Role[] registrosArreglo = objectMapper.readValue(respuesta, Role[].class);

				if (registrosArreglo != null & registrosArreglo.length > 0) {
					for(Role registro : registrosArreglo) {
						role.add(registro);
					}
				}

			} catch (Throwable e) {
				logger.error(e.getMessage());
				
			}
			
		}
		return role;
	}
	
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType arg3) throws SQLException {
		try {
			
			
			List<Role> objeto = new ArrayList<Role>();
			Role role =null;
			
			try {
				objeto = (List<Role>) parameter;
			} catch (Exception e) {
				
			}
			
			try {
				role=(Role) parameter;
			} catch (Exception e) {
				
			}
		
			if (role!=null) {
				objeto.add(role);
			}
			
			
			if (objeto != null) {
				
				PGobject pGobject = new PGobject();
				pGobject.setType("text");
				
				//---
				Gson gson = new Gson();
				String jsonResponse = gson.toJson(objeto);
				
				//---
				pGobject.setValue(jsonResponse);
				
				ps.setObject(i, pGobject, Types.OTHER);
			}else {
				ps.setObject(i, null, Types.OTHER);
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}




