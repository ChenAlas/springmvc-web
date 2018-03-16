package com.springmvc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception exc) {
		String msg = null;
		if (exc instanceof CustomerException) {
			CustomerException custExp = (CustomerException) exc;
			msg = custExp.getExpMessage();
		} else {
			exc.printStackTrace();
			StringWriter s = new StringWriter();
			PrintWriter pw = new PrintWriter(s);
			exc.printStackTrace(pw);
			msg = s.toString();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("error");
		return mav;
	}

}
