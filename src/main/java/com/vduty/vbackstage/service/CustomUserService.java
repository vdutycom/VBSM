package com.vduty.vbackstage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vduty.security.VsUserDetails;
import com.vduty.vbackstage.admin.mapper.AdminMapper;
import com.vduty.vbackstage.admin.mapper.PermissionMapper;
import com.vduty.vbackstage.user.entity.UsersEntity;
import com.vduty.vbackstage.user.mapper.UserMapper;





@Service
public class CustomUserService extends com.vduty.security.VsUserService {

	
	
	public  CustomUserService()
	{
		
	}
	
	
	
	 @Autowired
	 UserMapper userMapper;
	 
	 @Autowired
	 AdminMapper adminMapper;
	 
	 
	 @Autowired
	 PermissionMapper permissionMapper;
	 
	   
	    public VsUserDetails loadUserByUsername(String s)  {	    	
	    		    	
	    	UsersEntity normalUser = new UsersEntity(s);
	    	    	
	    	return normalUser;    	
	    	
	    
	    }	
}
