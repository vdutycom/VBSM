package com.vduty.vbackstage.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vduty.vbackstage.admin.entity.AdminsEntity;
import com.vduty.vbackstage.admin.mapper.AdminMapper;

@Controller
@RequestMapping("/vdutymanager")
public class AdminController {

	
	@Autowired
	AdminMapper adminMapper;
	
	@RequestMapping("")
	/**
	 * 
	 * @param model
	 * @return
	 */
	public String adminHome(Model model)
	{
		
		return "views/admin/index";
	}
	
	@RequestMapping("/usermanager")
	public  String userManager()
	{
		return "views/admin/usermanager";
	}
	
	
	
}
