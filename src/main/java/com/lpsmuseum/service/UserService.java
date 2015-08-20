package com.lpsmuseum.service;

import java.util.List;

import com.lpsmuseum.dao.UserDAO;
import com.lpsmuseum.dto.User;
import com.lpsmuseum.entity.UserDO;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public User getDto(UserDO udo) {
		User user = new User();
		user.setUsername(udo.getUsername());
		user.setType(udo.getType());
		return user;
	}
	
	public UserDO getEntity(User user) {
		UserDO udo = new UserDO();
		udo.setUsername(user.getUsername());
		udo.setType(user.getType());
		return udo;
	}
	
	public User login(UserDO userdo) {
		List<UserDO> udos = dao.listUsers();
		for (UserDO udo : udos)
			if (udo.getPassword().equals(userdo.getPassword()))
				return getDto(udo);
		return null;
	}

}
