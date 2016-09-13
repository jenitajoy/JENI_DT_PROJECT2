package com.niit.digi.dazzle.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digi.dazzle.dao.RegisterDaoImpl;
import com.niit.digi.dazzle.model.Register;

public class RegisterTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.digi.dazzle");
		context.refresh();
		
		
	   RegisterDaoImpl registerDaoImpl = 	(RegisterDaoImpl) context.getBean("registerDaoImpl");
	   
	 //  Register register = 	(Register) context.getBean("register");
	   //Register register=new Register();
	  // register.setId("us121");
	   //register.setName("usName121");
	   //register.setPassword("pwd");
	   //register.setMobile("943499999");
	   //register.setMail("bbb@gmail.com");
	   //register.setAddress("Madurai");
	   
	   
	   
	   
	 //registerDaoImpl.saveOrUpdate(register);  
	   
	//  registerDaoImpl.delete("us120"); 
	   
	   
	   registerDaoImpl.get("us120");
	   
	   
	   
	   
		
		
	}

}
