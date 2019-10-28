package com.jy.config.Interceptor;
/*\
拦截器
 */
import com.jy.config.constants.constants;
import com.jy.util.getIP;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class requestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        StringBuilder sb = new StringBuilder(1000);
//        String addrip=getIP.getIpAddr(request);
//        sb.append("请求访问时间:-----").append(constants.yhmd.format(new Date())).append("\n");
//        sb.append("请求IP:-----").append(addrip).append("\n");
//        //只看controller具体操作
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod h = (HandlerMethod) handler;
//            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
//            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
//            sb.append("URI       : ").append(request.getRequestURI()).append("\n");
//            System.out.println(sb.toString());
//        }


        // sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
