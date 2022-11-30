package com.nt.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomRequest extends HttpServletRequestWrapper {
private HttpServletRequest request;
	public CustomRequest(HttpServletRequest request) {
		super(request);
		this.request= request;
	}
	
	@Override
	public String getParameter(String name) {
		String paramval=request.getParameter(name);
		if (name.equals("email")) {
			if (!paramval.endsWith("@gmail.com")) {
				paramval=paramval+"@gmail.com";
			}
		}
	return paramval;
	} 
}
