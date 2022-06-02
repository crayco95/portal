package com.portal.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.StudentMapper;
import com.portal.model.Student;
@Service
public class StudentServiceDb {
	@Autowired
	public StudentMapper studentMapper;
	
	public List<Student> getAllStudentsDb() {
		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		studentMapper.getAllStudentsDb(parametrosInOout);
		List<Student> students = null;
		String codigoRespuesta = (String) parametrosInOout.get("p_cod_rpta");
		if(codigoRespuesta != null && codigoRespuesta.equals("OK")) {
			
			try {
				students = (List<Student>) parametrosInOout.get("p_student");
			} catch (Exception e) {
				students = null;
			}
		
		}else {
			students = null;
		}
		
		return students;
	}
}
