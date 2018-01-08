package com.vduty.security;


/*
 * 验证网址的属性
 * 
 */
public class ValidateUrlProperty {
	
	private String loginUrl="/login";
	private String loginFailUrl = "/login/?error";
	

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	private String loginSuccessUrl ;

	public String getLoginSuccessUrl() {
		return loginSuccessUrl;
	}

	public void setLoginSuccessUrl(String loginSuccessUrl) {
		this.loginSuccessUrl = loginSuccessUrl;
	}
	

}
