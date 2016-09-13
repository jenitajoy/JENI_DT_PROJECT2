package com.niit.digi.dazzle.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digi.dazzle.dao.ForumDao;
import com.niit.digi.dazzle.model.Forum;



public class ForumTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.digi.dazzle");
		context.refresh();
		
		
	   ForumDao forumDao = 	(ForumDao) context.getBean("forumDao");
	   
	   Forum forum = 	(Forum) context.getBean("forum");
	   forum.setFid("F100");
	   forum.setName("DT_BATCH-01");
	   forum.setMessage("Chat Application");
	   forum.setDate_time(new Date());
	      
	   
	   forumDao.saveOrUpdate(forum);
	   
	   
	   
	   
		
		
	}
}
