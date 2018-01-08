package com.vduty.vbackstage.user.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vduty.vbackstage.user.entity.UsersEntity;
import com.vduty.vbackstage.user.mapper.UserMapper;

@Controller
@RequestMapping("/usercenter/developers")
public class UserSellersController {
	static final Logger logger  =  LogManager.getLogger(UserSellersController.class);
	@Autowired
    private UserMapper userMapper;
	@RequestMapping("") 
	  public String requirementsIndex(Model model){
		String userName="";
		
	  /*if (  SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal() instanceof UserDetails)
	  {		
				UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();		
	        userName = userDetails.getUsername();
	  }
	  else
	  {
		  logger.info(" requirements: 用户未登录 ");
		  return  "redirect:/login";  
	  }*/
	  
	  model.addAttribute("username",userName);		
	  return"views/usercenter/developers/index"; 
	  } 
	
	
	
	@RequestMapping("/getuser/{id}")//id---userId
	public String getuser(@PathVariable Long id, Model model)
	{
		System.out.print("path id is : "+id);
		UsersEntity user  =userMapper.getOne(id);
		model.addAttribute("user",user);
		return "views/usercenter/developers/getuser";
	}
	

}
