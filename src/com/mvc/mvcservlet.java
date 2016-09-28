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
 * 处理请求和转发
 * 前端控制器
 * Servlet implementation class mvcservlet
 */
@WebServlet("/mvcservlet")
public class mvcservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Map<String, String> xmlmap=null;//存放了类名和相对应的类路径
    static int i=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mvcservlet() {
        super();
        i++;
        System.out.println(i);
        //获取配置
        if(xmlmap==null){
        	xmlmap=XMLMap.getXMLMap().getMap();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("请求开始");
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
		//截取
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		String resutl=null;//路径
		try {
			String classpath=xmlmap.get(action);//获取要执行的类的路径
			if(classpath!=null){
				Class c=Class.forName(classpath);//反射，获取类
				Action ac=(Action) c.newInstance();//实例化, c.newInstance()=new loginAction(),Action ac=(Action);
				
				resutl=ac.Methods(request, response);//执行该方法
				System.out.println("成功");
				request.removeAttribute("test");
				request.getSession().setAttribute("qwe", "123");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		if(resutl!=null)
			request.getRequestDispatcher(resutl).forward(request, response);//请求转发
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
