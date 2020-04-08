package com.jy.config.aspect;
/*
 aop 切点 切入到controller 方法里 用于记录请求

 */
import com.jy.config.constants.constants;
import com.jy.util.getIP;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Aspect
public class logAspect {
    private Logger logger = Logger.getLogger(logAspect.class);

    @Pointcut("execution(public * com.jy.controller..*.*(..))")//对controller包下的控制层都切入进去
    public void logController() {
    }//切面方法

    @Before("logController()")//在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        System.out.println("############请求记录开始############");
        StringBuilder sb = new StringBuilder(1000);
        String addrip = getIP.getIpAddr(request);
        sb.append("请求访问时间:-----").append(constants.yhmd.format(new Date())).append("\n");
        sb.append("请求IP:-----").append(addrip).append("\n");
        sb.append("Controller: ").append(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()).append("\n");
        sb.append("MethodType    : ").append(request.getMethod()).append("\n");
        sb.append("URI       : ").append(request.getRequestURI()).append("\n");
        System.out.println(sb.toString());
        System.out.println("############请求记录结束############");
        //logger.info("请求URL : " + request.getRequestURL().toString());
        //logger.info("请求方法HTTP_METHOD : " + request.getMethod());
        // logger.info("请求IP : " + request.getRemoteAddr());
        //logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        //logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

    }
}
