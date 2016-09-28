package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class newupload
 */
@WebServlet("/newupload")
@MultipartConfig
public class newupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newupload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		String path=request.getParameter("lujin");//要存放的路径
		Part filePart=request.getPart("file");//文件
		String fileName=getFileName(filePart);
        OutputStream out=new FileOutputStream(new File(path+ File.separator+fileName));
        InputStream filecontent=filePart.getInputStream();
        int read;
        byte[] bytes=new byte[1024];
        while((read=filecontent.read(bytes))!=-1){
        	out.write(bytes, 0, read);
        }
	}
	private String getFileName(Part part){
		String partHear=part.getHeader("content-disposition");
		for(String content:partHear.split(";")){
			if(content.trim().startsWith("filename")){
				return  content.substring(content.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
