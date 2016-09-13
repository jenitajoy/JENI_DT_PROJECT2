package com.niit.digi.dazzle.dao;

import java.util.List;

import com.niit.digi.dazzle.model.Forum;



public interface ForumDao {

	public List<Forum> list();

	public Forum get(String fid);

	public void saveOrUpdate(Forum forum);

	public void delete(String fid);
}
