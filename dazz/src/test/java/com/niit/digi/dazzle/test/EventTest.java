package com.niit.digi.dazzle.test;




import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digi.dazzle.dao.EventDao;
import com.niit.digi.dazzle.model.Event;


public class EventTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.digi.dazzle");
		context.refresh();
		
		
		EventDao eventDao = 	(EventDao) context.getBean("eventDao");
	   
		Event event = 	(Event) context.getBean("event");
		event.setEid("E002");
		event.setEname("Project");
		event.setDate(new Date());
		event.setVenue("ByePass");
		event.setDescription("E-commerce");
		
	  
	   
	   
	  eventDao.saveOrUpdate(event);
	   
	   
	   
	   
		
		
	}

}
