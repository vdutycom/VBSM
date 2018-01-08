package com.vduty.vbackstage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.vduty.vbackstage.user.entity.UsersEntity;
import com.vduty.vbackstage.utils.RandomUtils;
import com.vduty.vbackstate.redis.utils.RedisUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	
	@Autowired
    private  StringRedisTemplate stringRedisTemplate;
		
	
	@Test
	public void redistest()
	{
		stringRedisTemplate.opsForValue().set("aaa", "ccc");
		RedisTemplate<String, UsersEntity> redisTemplate  = new RedisTemplate<>();
		
		redisTemplate.opsForValue().set("luther", new UsersEntity("luther"));
		
		
		@SuppressWarnings("unused")
		UsersEntity user = (UsersEntity)redisTemplate.opsForValue().get("luther");
		
		
		
		/*
		UsersEntity user = new UsersEntity("luther");
		
		RedisUtils.setObject(user.getUsername(), user);
		
		user = (UsersEntity) RedisUtils.getObject(user.getUserName());
		
		System.out.println(user.getUsername());*/
		
	}
	
	@Test
	public void randomTest()
	{
		System.out.println("randomTest");
		
	    
		int[] aint = {1,2,3,5,6,7,8,9,0}; 
		
		/*System.out.println("根据数字生成一个定长的字符串，长度不够前面补0:"
				+ toFixdLengthString(123, 10));
		int[] in = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("每次生成的len位数都不相同:" + getNotSimple(in, 3));*/
				
		
		System.out.println(RandomUtils.toFixdLengthString(RandomUtils.getNotSimple(  aint,8), 8) );
	}

}
