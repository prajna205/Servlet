package com.nt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener 
public class RequestAnalyzerListenser implements ServletRequestListener{
	private long start,end;
	
	public RequestAnalyzerListenser() {
		System.out.println("RequestAnalyzerListenser::-0 param constructor");
	}
	 
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListenser::requestInitialized()");
		start=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListenser::requestDestroyed()");		
		end=System.currentTimeMillis();
		//get http servlet request obj
		HttpServletRequest req = (HttpServletRequest)sre.getServletRequest();
		//get servlet context obj
		ServletContext sc=req.getServletContext();
		sc.log(req.getRequestURI() +"has taken "+(end-start)+"ms time to process the request");
	}
}
