package com.vduty.vbackstage.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.vduty.vbackstage.security.MyFilterSecurityInterceptor;
import com.vduty.vbackstage.service.CustomUserService;
import com.vduty.vbackstate.RedisObjectSerializer;

@Configuration //相当于xml配置beans
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	static final  Logger logger  = LogManager.getLogger(SecurityConfig.class);	

   

   @Autowired
    private CustomUserService customerService;

   
   @Override  
   protected void configure(HttpSecurity http) throws Exception {  
       http  
       .authorizeRequests()  
       .antMatchers("/*").permitAll();
      
   }  
   
  
   /*@Bean
   public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
       RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
       template.setConnectionFactory(factory);
       template.setKeySerializer(new StringRedisSerializer());
       template.setValueSerializer(new RedisObjectSerializer());
       return template;
   }*/
   
    
    @Bean 
    /**
     * 注册过滤器
     * @param filter
     * @return
     * 该方式注册的过滤去，不在HttpSecurity http里注册也生效，并且过滤器的@WebFilter也会生效
     */
    public FilterRegistrationBean registration(MyFilterSecurityInterceptor filter) {  
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
       //  关闭spring boot filter的自动注册 ，注：spring boot 对过滤器自动注册，默认过滤行为"/*" 
        registration.setEnabled(false); 
        return registration;
    }    
    
   /* @Bean  
    public ServletRegistrationBean myServlet() {  
        ServletRegistrationBean myServlet = new ServletRegistrationBean();  
        myServlet.addUrlMappings("/servlet");  
        myServlet.setServlet(new MyServlet());  
        return myServlet;  
    }  */
    
    

}
