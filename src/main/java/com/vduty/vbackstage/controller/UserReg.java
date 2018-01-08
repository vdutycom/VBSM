package com.vduty.vbackstage.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vduty.vbackstage.user.entity.UsersEntity;
import com.vduty.vbackstage.user.mapper.UserMapper;
import com.vduty.vbackstage.utils.RandomUtils;

@Controller
@RequestMapping("/regist")
public class UserReg {

	static final Logger logger = LogManager.getLogger(UserReg.class);
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("")
	public String regist(Model model)
	{
		String password = "aaaa";		
		logger.info("current password:"+password); 
        String userName = RandomUtils.generateLowerString(6); 			       
		UsersEntity user  = new UsersEntity(userName); 
		user.setLoginName(userName);
		user.setNickName(userName);
		user.setPassword(password);
		int[] intArr =  {1,2,3,5,6,7,8,9,0}; 
		user.setPhone("138" + RandomUtils.toFixdLengthString(RandomUtils.getNotSimple(  intArr,8), 8));
		user.setEmail(userName + "@vduty.com");
			
		userMapper.insert(user);	
		
		model.addAttribute("user",user);
		
		return "views/regist";		
	}
	
	/**
	 * 提交用户注册信息
	 */
	@RequestMapping("/save")
	public String  saveUser()
	{
		
		return "views/registresult";
		
	}
	
}
