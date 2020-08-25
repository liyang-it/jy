package com.jy;

import com.jy.util.reloadSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.Serializable;

@SpringBootApplication
@Configuration
@MapperScan("com.jy.mapper")
@EnableTransactionManagement
public class JyApplication extends SpringBootServletInitializer {

  @Bean
  public reloadSource reloadSource() {
    return new reloadSource();
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    // 注意这里要指向原先用main方法执行的Application启动类
    return builder.sources(JyApplication.class);
  }

  public static void main(String[] args) {

    SpringApplication.run(JyApplication.class, args);
  }



}
