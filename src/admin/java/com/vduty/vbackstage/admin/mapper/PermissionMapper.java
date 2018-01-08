package com.vduty.vbackstage.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.vduty.vbackstage.admin.entity.AuthoritiesEntity;
import com.vduty.vbackstage.user.entity.UsersEntity;

/**
 * 管理权限
 * @author lye
 *
 */
public interface PermissionMapper {

	/*
     * 通过登录名获
     * 
     */
    @Select("select p.id,p.name,p.description,p.path,p.pid from"
    		+ "   		 admins u "
    		+ "  		 left join admins_to_roles utr  on u.id =  utr.admin_id "
    		+ "   		left join admin_roles ur on utr.role_id = ur.id  "
    		+ "   		left join roles_to_permits rtp  on  rtp.role_id = utr.role_id "
    		+ "   		left join  permissions p  on p.id = rtp.permit_id "
    		+ "   		 where  u.id= #{userid}")
    @Results({
        @Result(property = "actionName",  column = "action_name"),
        @Result(property = "actionKey", column = "action_key")
    })
    List<AuthoritiesEntity>   findOneUser(long userid);
    
   /**
    * 获取全部权限
    * @return
    */
    @Select("select id,name,description,path,pid from permissions ")    
    List<AuthoritiesEntity>    findAll();
     
    
	  
	
	
	
}
