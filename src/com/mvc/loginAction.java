package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登陆的方法
 * 这里可以处理下登陆前的逻辑处理
 * 返回登陆的地址
 * @author Administrator
 *
 */
public class loginAction implements Action {
	
	@Override
	public String Methods(HttpServletRequest request, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		request.setAttribute("test", "j12");  
		System.out.println("登陆的方法");
		return "log.jsp";
	}
	
}
