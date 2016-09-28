package com.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
/**
 * 读取配置文件
 * 单例
 * 返回静态的配置信息的map类
 * @author Administrator
 *
 */
public class XMLMap {
	//单例
	private static XMLMap m=null;
	//存放静态的map集合
	private static Map<String,String> xmlmap=new HashMap<String,String>();
	//初始化类时读取配置信息
	private XMLMap(){
	       SAXBuilder buider=new SAXBuilder();//读取xml的构造器
	       Document readDc=null;//xml对象
	       try {
			readDc=buider.build(this.getClass().getClassLoader().getResource("/").getPath()+"mvcxml.xml");//获取绝对路径并读取
	       } catch (JDOMException e) {
	    	   e.printStackTrace();
	       } catch (IOException e) {
	    	   e.printStackTrace();
	       }
	       Element stu=readDc.getRootElement();//获取根节点
	       List list=stu.getChildren("action");//子节点集合
	       	//循环读取
	       for(int i=0;i<list.size();i++){
	    	   Element e=(Element)list.get(i);
	    	   String name=e.getChildText("name");
	    	   String c=e.getChildText("class");
	    	   xmlmap.put(name, c);
	    	   System.out.println(name+":"+c);
	       }
	}
	/**
	 * 获取对象
	 * @return
	 */
	public static XMLMap  getXMLMap(){
		if(m==null){
			m=new XMLMap();
		} 
		return m;
	}
	/**
	 * 获取集合
	 * @return
	 */
	public static Map<String, String> getMap(){
		return xmlmap;
	}
}
