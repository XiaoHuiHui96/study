package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��½�ķ���
 * ������Դ����µ�½ǰ���߼�����
 * ���ص�½�ĵ�ַ
 * @author Administrator
 *
 */
public class loginAction implements Action {
	
	@Override
	public String Methods(HttpServletRequest request, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		request.setAttribute("test", "j12");  
		System.out.println("��½�ķ���");
		return "log.jsp";
	}
	
}
