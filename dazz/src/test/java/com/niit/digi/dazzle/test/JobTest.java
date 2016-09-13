package com.niit.digi.dazzle.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.digi.dazzle.dao.JobDao;
import com.niit.digi.dazzle.model.Job;

public class JobTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.digi.dazzle");
		context.refresh();
		
		
	   JobDao jobDao = 	(JobDao) context.getBean("jobDao");
	   
	   Job job = 	(Job) context.getBean("job");
	   job.setJobid("1002");
	   job.setCmpy_name("Accenture");
	   job.setDescription("Top MNC company");
	   job.setQualification("B.Tech/B.E");
	   job.setExperience("Fresher");
	   job.setVacancy("120");
	  
	   
	   
	  jobDao.saveOrUpdate(job);
	   
	  // jobDao.delete("1001");
	   
	   
	   
	   
		
		
	}
}
