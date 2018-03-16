package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exc)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Interceptor1 afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Interceptor1 postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURL().toString();
		if (uri.contains("login")) {
			return true;
		}
		System.out.println("Interceptor1 preHandle");
		HttpSession session = request.getSession();
		Object username = session.getAttribute("username");
		if (username != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/user/showlogin");
		return false;
	}

}
