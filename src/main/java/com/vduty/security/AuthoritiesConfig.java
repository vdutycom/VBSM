/*
 * 
 * 本包可以独立工程，生成.jar包给做为被调用的库
 *  
 * 
 * 
 * */
package com.vduty.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * 
 * 验证配置
 * @author Administrator
 *
 */
public class AuthoritiesConfig {
	
	
	public  AuthoritiesConfig(Map<String, ValidateUrlProperty> url)
	{
		
		this.ValidateUrl = url;
		
	}
	
	/**
	 * 过滤网址配置
	 * @return
	 */
	public Map<String, ValidateUrlProperty> getValidateUrl() {
		return ValidateUrl;
	}

	public void setValidateUrl(Map<String, ValidateUrlProperty> validateUrl) {
		ValidateUrl = validateUrl;
	}

	Map<String,ValidateUrlProperty >  ValidateUrl =  new HashMap<String,ValidateUrlProperty>();
	
	
	
}
