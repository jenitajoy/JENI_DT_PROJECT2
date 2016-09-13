package com.niit.digi.dazzle.dao;

import java.util.List;

import com.niit.digi.dazzle.model.Job;

public interface JobDao {

	public List<Job> list();

	public Job get(String jobid);
	
	public void saveOrUpdate(Job job);

	public void delete(String jobid);
}
