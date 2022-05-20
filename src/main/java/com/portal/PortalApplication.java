package com.portal;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.portal.model.Student;

@MappedTypes(Student.class)
@MapperScan("com.portal.dao")
@SpringBootApplication
public class PortalApplication implements CommandLineRunner{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String password ="amigo123";
		
		for(int i=0; i<2; i++) {
			
			String bycryptPassword = passwordEncoder.encode(password);
			System.out.println(bycryptPassword);
		}
	}

}
