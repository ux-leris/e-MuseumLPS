package com.lpsmuseum.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserDO
 *
 */
@Entity
public class UserDO implements Serializable {

	   
	@Id
	private String username;
	private String password;
	private Integer type;
	private static final long serialVersionUID = 1L;

	public UserDO() {
		super();
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
   
}
