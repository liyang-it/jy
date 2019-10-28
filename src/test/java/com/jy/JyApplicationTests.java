package com.jy;

import com.jy.util.getValue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JyApplicationTests {

	@Test
	void contextLoads() {
		getValue g=new getValue();
		System.out.println(g.getlineContent("我真的爱你,你知道吗.你不知道,你哥sahbi。"));
	}

}
