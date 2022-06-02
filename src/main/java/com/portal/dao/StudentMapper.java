package com.portal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;


import com.portal.model.Student;
@Mapper
public interface StudentMapper {
	

	public List<Student> findAll();
	
	public void getAllStudentsDb(HashMap<Object, Object> parametrosINOUT);
	
	public Student getStudent(int id);
	
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int id);
	
}
