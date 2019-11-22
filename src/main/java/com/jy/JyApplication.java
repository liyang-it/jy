package com.jy;

import com.jy.util.reloadSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@Configuration
@MapperScan("com.jy.mapper")
@EnableTransactionManagement
public class JyApplication {

	@Bean
	public reloadSource reloadSource(){
		return new reloadSource();
	}
	public static void main(String[] args) {

		SpringApplication.run(JyApplication.class, args);
	}



}
