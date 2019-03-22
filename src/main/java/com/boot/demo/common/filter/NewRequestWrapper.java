package com.boot.demo.common.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.tomcat.util.buf.StringUtils;

import com.boot.demo.common.utils.CryptoUtil;

public class NewRequestWrapper extends HttpServletRequestWrapper{
	 private Map<String , String[]> params = new HashMap<String, String[]>();
	 
	 
	    public NewRequestWrapper(HttpServletRequest request) throws Exception {
	        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
	        super(request);
	        Map<String, String[]> parameterMap = request.getParameterMap();
	        for (Entry<String, String[]> entry : parameterMap.entrySet()) { 
	        	/*StringBuffer val = new StringBuffer();
	        	for (String s : entry.getValue()) {
	        		val.append(s);
	        	}*/
	        	String val = StringUtils.join(entry.getValue());
	        	String decode = CryptoUtil.decode(entry.getKey(), val);
	        	System.out.println("Key = " + entry.getKey() + ", Value = " + val);
	        	addParameter(entry.getKey(), decode);
	        }
	        //将参数表，赋予给当前的Map以便于持有request中的参数
	        //this.params.putAll(request.getParameterMap());
	    }
	    /*//重载一个构造方法
	    public NewRequestWrapper(HttpServletRequest request , Map<String , Object> extendParams) {
	        this(request);
	        addAllParameters(extendObject);//这里将扩展参数写入参数表
	    }*/
	    
	    @Override
	    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
	        String[]values = params.get(name);
	        if(values == null || values.length == 0) {
	            return null;
	        }
	        return values[0];
	    }
	    
	    public String[] getParameterValues(String name) {//同上
	         return params.get(name);
	    }
	 
	   public void addAllParameters(Map<String , Object> otherParams) {//增加多个参数
	        for(Map.Entry<String , Object>entry : otherParams.entrySet()) {
	            addParameter(entry.getKey() , entry.getValue());
	        }
	    }
	 
	 
	    public void addParameter(String name , Object value) {//增加参数
	        if(value != null) {
	            if(value instanceof String[]) {
	                params.put(name , (String[])value);
	            }else if(value instanceof String) {
	                params.put(name , new String[] {(String)value});
	            }else {
	                params.put(name , new String[] {String.valueOf(value)});
	            }
	        }
	    }
	}

