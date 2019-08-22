package com.example.curso.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMvcApplicationTests {

	@Test
	public void contextLoads() {
		
		String password = "123"; 
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    String encodedPassword = passwordEncoder.encode(password);  
	    System.out.println("encodedPassword: " +encodedPassword);
	    
		BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder2.encode(password);
		
		System.out.println("hashedPassword: " +hashedPassword);
	    
	    //user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

	}

}
