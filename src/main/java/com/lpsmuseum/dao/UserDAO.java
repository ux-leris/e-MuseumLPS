package com.lpsmuseum.dao;

import java.util.List;

import com.lpsmuseum.entity.UserDO;

public class UserDAO extends BasicDAO {

	@Override
	public Object findEntity(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDO> listUsers() {
		return list("UserDO");
	}

}
