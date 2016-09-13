package com.niit.digi.dazzle.dao;

import java.util.List;

import com.niit.digi.dazzle.model.Event;



public interface EventDao {

	public List<Event> list();

	public Event get(String eid);

	public void saveOrUpdate(Event event);

	public void delete(String eid);
}
