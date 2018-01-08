package com.vduty.vbackstate.redis.utils;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class RedisUtils {
	
	@Autowired
    private  StringRedisTemplate stringRedisTemplate;
    
   
    
    public  String getString(String key)
    {
    	
    	return  stringRedisTemplate.opsForValue().get(key);
    }
    public  void setString(String key, String value)
    {
    	stringRedisTemplate.opsForValue().set(key, value);
    }
    
    

}
