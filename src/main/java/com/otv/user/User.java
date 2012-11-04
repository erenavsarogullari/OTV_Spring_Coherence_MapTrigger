package com.otv.user;

import java.io.Serializable;

/**
 * User Bean
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = -1963764656789800896L;
	
	private String id;
	private String name;
	private String surname;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuff = new StringBuilder();
		strBuff.append("id : ").append(id);
		strBuff.append(", name : ").append(name);
		strBuff.append(", surname : ").append(surname);
		return strBuff.toString();
	}
}
