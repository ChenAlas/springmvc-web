package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		// 返回ModelAndView之后
        // Handler执行过程中出现异常，可以在此处理异常
        System.out.println("Interceptor1 afterCompletion........");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		// Handler执行之后，在返回ModelAndView之前，对modelAndView做些手脚
        System.out.println("Interceptor1 postHandle........");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Interceptor1 preHandle........");
        // 执行的时机是在Handler执行之前执行此方法
        // 返回值：如果返回true，就放行，不拦截，正常执行Handler进行处理
        // 返回值：如果返回false，那就拦截，Handler就不能正常处理了
        return true;
	}

}
