package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �����Ľӿ�
 * @author Administrator
 *
 */
public interface Action {
	public String Methods(HttpServletRequest request,HttpServletResponse resp);
}
