package com.jy.config.mvc;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截错误请求，返回错误信息
 */
public class MvcExceptionResolver implements HandlerExceptionResolver {
    private Logger logger=Logger.getLogger(MvcExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String errorMsg="";
            boolean isAjax= "1".equals(request.getParameter("isAjax"));

            //ex 为业务层抛出的自定义异常
            if(ex instanceof ServiceCustomException){
                ServiceCustomException customEx=    (ServiceCustomException)ex;

                errorMsg ="customStatus:"+customEx.getCustomStatus() +",customMessage:"+customEx.getCustomMessage()
                        +"\r\n"+ ExceptionUtils.getStackTrace(customEx);
                logger.error(errorMsg);
            }else{
                //ex为非自定义异常，则
                errorMsg=ExceptionUtils.getStackTrace(ex);
                logger.error(errorMsg);

            }

            if(isAjax){

                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(AjaxUtil.messageMap(500, errorMsg)));
                return new   ModelAndView();
            }else{
                //否则，  输出错误信息到自定义的500.jsp页面
                ModelAndView mv = new ModelAndView("500.html");
                mv.addObject("errorMsg", errorMsg);
                return mv ;
            }
        } catch (IOException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return new   ModelAndView();

    }

    }

