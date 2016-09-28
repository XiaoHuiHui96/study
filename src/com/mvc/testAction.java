package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class testAction implements Action {

	@Override
	public String Methods(HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("≤‚ ‘∑Ω∑®");
		
		return "test.jsp";
	}

}
