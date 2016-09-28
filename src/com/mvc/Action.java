package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 方法的接口
 * @author Administrator
 *
 */
public interface Action {
	public String Methods(HttpServletRequest request,HttpServletResponse resp);
}
