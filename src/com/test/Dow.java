package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dow
 */
@WebServlet("/Dow")
public class Dow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realpath="E:\\杂类\\命令模式.doc";//下载的文件路径
		String filename="命令模式.doc";//文件名
		response.setHeader("content-disposition", "attachment;filename="+filename);//通知浏览器以下载的方式，filename就下载时显示的文件名
		//获取流并通过响应对象输出
		FileInputStream in=new FileInputStream(realpath);
		int len=0;
		byte buffer[]=new byte[1024];
		OutputStream out=response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
