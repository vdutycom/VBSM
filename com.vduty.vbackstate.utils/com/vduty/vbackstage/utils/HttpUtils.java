package com.vduty.vbackstage.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {
	
	public static String  getHost(HttpServletRequest req)
	{
		String host =   req.getScheme()+"://" + req.getServerName();
		if (req.getServerPort()!=80)
		{
			host += ":" + req.getServerPort();
		}
		return host;
	}
	
	public static String getDomain(HttpServletRequest req)
	{
		return req.getServerName();
		
	}
	
	public static String getCurUrl(HttpServletRequest req)
	{
		String url = req.getScheme()+"://"+ req.getServerName();
		if (req.getServerPort()!=80)
		{
			url += ":" + req.getServerPort();
		}
		
		if (req.getRequestURI()!=null)
		{
           url += 	req.getRequestURI();		
		}
		
		if (req.getQueryString()!=null)
		{
           url += "?"+req.getQueryString();	
		}
		
		return url;	
	}

}
