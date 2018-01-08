package com.vduty.vbackstage.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.vduty.vbackstage.user.entity.UserRoles;
import com.vduty.vbackstage.user.entity.UsersEntity;



/**
 * 
 * @author lye
 *
 */
public interface UserMapper {

	/**
	 * 
	 * @return
	 */
	 @Select("SELECT * FROM users")
	@Results({
        //@Result(property = "userSex",  column = "sex", javaType = UserSexEnum.class),
        
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "loginName", column = "login_name"),
        @Result(property = "password", column = "password")
    })
    List<UsersEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
        
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "loginName", column = "login_name"),
        @Result(property = "password", column = "password")
    })
    UsersEntity getOne(Long id);
    
    /*
     * 通过登录名获取用户
     * 
     */
    @Select("SELECT * FROM users WHERE login_name = #{loginName}")
    @Results({
    	
          @Result(property = "nickName", column = "nick_name"),
          @Result(property = "loginName", column = "login_name"),
          @Result(property = "password", column = "password"),
          
    })
    UsersEntity getOneByName(String loginName);
    
    /*
     * 通过用户id获取权限
     * 
     */
    @Select("select ur.* from  users_to_roles utr  join user_roles ur on ur.id = utr.role_id where utr.user_id = #{userId}")
    @Results({
        @Result(property = "roleKey",  column = "role_key"),        
    })
    List<UserRoles> getUserRoles(long userId);    
    
    
    
    @Insert("INSERT INTO users(login_name,password,sex,phone,email) VALUES(#{loginName}, #{password}, #{sex},#{phone},#{email})")
    void insert(UsersEntity user);
    
    

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UsersEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
	
	
}
