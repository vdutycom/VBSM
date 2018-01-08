package com.vduty.vbackstage.user.entity;

import com.vduty.vbackstage.entity.UsersBaseEntity;


public class UsersEntity extends UsersBaseEntity  {

	
	
	public UsersEntity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
