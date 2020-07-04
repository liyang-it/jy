package com.jy;

import com.jy.util.redisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JyApplicationTests {
	@Autowired
	private redisUtils redisUtils;

	@Test
	void contextLoads() {
		redisUtils.sout();

	}

}
