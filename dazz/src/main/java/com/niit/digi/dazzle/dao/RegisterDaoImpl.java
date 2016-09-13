package com.niit.digi.dazzle.dao;

import java.util.List;



import com.niit.digi.dazzle.model.Register;

public interface RegisterDaoImpl {

	public List<Register> list();

	public Register get(String id);
	
	public void saveOrUpdate(Register register);

	public void delete(String id);
}
