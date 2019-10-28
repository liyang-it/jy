package com.jy.config.Validated;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
/*
1、普通模式（默认是这个模式）
　　普通模式(会校验完所有的属性，然后返回所有的验证失败信息)

返回目录
2、快速失败返回模式
　　快速失败返回模式(只要有一个验证失败，则返回)
failFast：true  快速失败返回模式    false 普通模式
当前配置为快速返回模式
 */
@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
}
