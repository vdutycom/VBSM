package com.vduty.vbackstage.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.vduty.vbackstage.configs.Constants;
import com.vduty.vbackstage.user.entity.UsersEntity;
import com.vduty.vbackstage.user.mapper.UserMapper;
import com.vduty.vbackstage.utils.RegexUtil;
import com.vduty.vbackstate.RedisObjectSerializer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
	
	@Autowired
	UserMapper userMapper;
	 
	
	 
	 
	 @Autowired
	  StringRedisTemplate stringRedisTemplate;
	 
	 
	 @Autowired
		private RedisTemplate redisTemplate;
	
	/**
	 * 首页
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String index(HttpServletRequest request, HttpSession session, Model model) {

		 UsersEntity user = new UsersEntity("luther");
		  System.out.println(user.getUserName());
		  
		  
		  ValueOperations<String, UsersEntity> operations=redisTemplate.opsForValue();
		  
		
		  
	        operations.set("luther", user);
	        
	        
		  
        // redisTemplate.opsForValue().set("luther", user);
               
         
         
        // UsersEntity user =    (UsersEntity)redisTemplate.opsForValue().get("luther");
        
         //System.out.println(redisTemplate.opsForValue().get("luther"));
         //logger.info(user.getUserName());
         
         
		//stringRedisTemplate.opsForValue().set("luther", "111");
		
		
		return "views/index";
	}
	
	
    /**
     * 测试页 
     * @param session
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/home")
	public String home(HttpSession session, HttpServletRequest request,Model model) {			
		
		
		
		
		return "views/index";
	}

	

	/**
	 * 登录页 
	 * @param request
	 * @param res
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse res, HttpSession session, Model model) {	
		
		
		
		UsersEntity user =   (UsersEntity)redisTemplate.opsForValue().get("luther");
		 
		System.out.print(user.getUserName());
		
		return "/views/login";
	}
	
	
	@RequestMapping("/adminlogin")
	public String adminLogin(HttpServletRequest request, HttpServletResponse res, HttpSession session, Model model) {	
		
		
		return "/views/adminlogin";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value ="/adminlogin",method = RequestMethod.POST)
	public String adminLoginDo(HttpServletRequest req,HttpServletResponse res ,Model model)
	{
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		if (RegexUtil.isNull(username))
		{
			model.addAttribute("error", "用户名不能为空");
			return "/adminlogin";
		}
		
		if (RegexUtil.isNull(password))
		{
			try {
				return "/adminlogin/?error=" + URLEncoder.encode("password=null","utf8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.print(username + "   "  + password);
		
		UsersEntity user = 	 userMapper.getOneByName(username);
		if (user !=null)
		{
			String userPassword = user.getPassword();
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder(); 
			if ( pe.matches(password, userPassword))
			{
				
				//保存权限
				//....
				//jwt
				 String token = Jwts.builder()  
			                .setSubject(username)  
			                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))  
			                .signWith(SignatureAlgorithm.HS512, Constants.JWT_SECURITY_KEY)  
			                .compact();  
			        res.addHeader("Authorization", Constants.JWT_TOKEN_FLAG + token); 
				
			      //登录成功
					stringRedisTemplate.opsForValue().set(username+"_authtoken", token);
				
			}
			else
			{
				//登录失败
			}
			
		}
		else
		{
			
		}
			
		
		
		if (req.getSession().getAttribute(Constants.REFER_URL_KEY) != null)
		{
		return "redirect:" +  req.getSession().getAttribute(Constants.REFER_URL_KEY);
		}
		
		return "/";
	}
	

	/**
	 * 登录成功
	 * @return
	 */
	@RequestMapping("/loginsucc")
	public String loginSucc() {

		return "loginSucc";
	}
	

}
