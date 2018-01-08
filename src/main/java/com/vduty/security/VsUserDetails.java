package com.vduty.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class VsUserDetails implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public VsUserDetails()
	{
		
	}
	
	public  VsUserDetails(String name)
	{
		
		this.userName = name;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id; 
	}

	public Map<String, VsAuthorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Map<String, VsAuthorities> authorities) {
		this.authorities = authorities;
	}

	private String userName;
	private long id;
	
	private Map<String,VsAuthorities> authorities = new HashMap<String,VsAuthorities>();
	 
	
	/**
	 * 判断权限
	 * @param auth
	 * @return
	 */
	public boolean HasAuthority(String auth)
	{
		if (null!= this.authorities.get(auth))
		{
			return true;
		}
		
		return false;
	}


	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取用户名称和ID
	 * @param request
	 * @return
	 */	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getCurrentUserNameAndId(HttpServletRequest request )
	{
		Map<String,Object> map = new HashMap<String , Object>();
	  	
		String name = null;
		long id=0;
		if(request.getSession().getAttribute("VsSessionUserMapInfo") != null )
		{		
			 
			  map =  (HashMap<String,Object>) request.getSession().getAttribute("VsSessionUserMapInfo");
		}	
	
		
		return map;
		
	}
	
	
}
