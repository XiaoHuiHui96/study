package com.mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * ���������ת��
 * ǰ�˿�����
 * Servlet implementation class mvcservlet
 */
@WebServlet("/mvcservlet")
public class mvcservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Map<String, String> xmlmap=null;//��������������Ӧ����·��
    static int i=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mvcservlet() {
        super();
        i++;
        System.out.println(i);
        //��ȡ����
        if(xmlmap==null){
        	xmlmap=XMLMap.getXMLMap().getMap();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("����ʼ");
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt;
		conn=(Connection)request.getAttribute("con");
				try {
					stmt = conn.createStatement();
					System.out.println(stmt);
					rs = stmt.executeQuery("select *  from ych");
					if(rs!=null){
						while(rs.next()){
							System.out.println(rs.getString(1));
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
*/
		//��ȡ
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		String resutl=null;//·��
		try {
			String classpath=xmlmap.get(action);//��ȡҪִ�е����·��
			if(classpath!=null){
				Class c=Class.forName(classpath);//���䣬��ȡ��
				Action ac=(Action) c.newInstance();//ʵ����, c.newInstance()=new loginAction(),Action ac=(Action);
				
				resutl=ac.Methods(request, response);//ִ�и÷���
				System.out.println("�ɹ�");
				request.removeAttribute("test");
				request.getSession().setAttribute("qwe", "123");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		if(resutl!=null)
			request.getRequestDispatcher(resutl).forward(request, response);//����ת��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
