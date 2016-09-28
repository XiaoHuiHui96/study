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
 * ��ȡ�����ļ�
 * ����
 * ���ؾ�̬��������Ϣ��map��
 * @author Administrator
 *
 */
public class XMLMap {
	//����
	private static XMLMap m=null;
	//��ž�̬��map����
	private static Map<String,String> xmlmap=new HashMap<String,String>();
	//��ʼ����ʱ��ȡ������Ϣ
	private XMLMap(){
	       SAXBuilder buider=new SAXBuilder();//��ȡxml�Ĺ�����
	       Document readDc=null;//xml����
	       try {
			readDc=buider.build(this.getClass().getClassLoader().getResource("/").getPath()+"mvcxml.xml");//��ȡ����·������ȡ
	       } catch (JDOMException e) {
	    	   e.printStackTrace();
	       } catch (IOException e) {
	    	   e.printStackTrace();
	       }
	       Element stu=readDc.getRootElement();//��ȡ���ڵ�
	       List list=stu.getChildren("action");//�ӽڵ㼯��
	       	//ѭ����ȡ
	       for(int i=0;i<list.size();i++){
	    	   Element e=(Element)list.get(i);
	    	   String name=e.getChildText("name");
	    	   String c=e.getChildText("class");
	    	   xmlmap.put(name, c);
	    	   System.out.println(name+":"+c);
	       }
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public static XMLMap  getXMLMap(){
		if(m==null){
			m=new XMLMap();
		} 
		return m;
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public static Map<String, String> getMap(){
		return xmlmap;
	}
}
