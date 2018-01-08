package com.vduty.security;

/**
 * 用户详情
 * @author Administrator
 *
 */
public class VsUserService {
	
	public VsUserDetails loadUserByUsername(String loginname)	
	{
		
		return new VsUserDetails(loginname);
		
	}
	
	
}
