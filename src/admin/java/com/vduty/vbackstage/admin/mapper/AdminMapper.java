package com.vduty.vbackstage.admin.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.vduty.vbackstage.admin.entity.AdminsEntity;

/**
 * admins 的dao层,admin 的CURD sql 操作
 * @author lye
 *
 */
public interface AdminMapper {
	/**
	 * 获取admin信息
	 * @param adminName
	 * @return
	 */
	@Select("SELECT * FROM admins where name  =#{name} ")
	@Results({
		
		@Result(property = "lastLoginIp", column = "last_loginip"),
		@Result(property = "lastLoginTime", column = "last_logintime"),
		@Result(property = "loginTimes", column = "login_times"),
		@Result(property = "trueName", column = "true_name")
	})
	public AdminsEntity getOne(String name);
	
	
	
	
	
	
}
