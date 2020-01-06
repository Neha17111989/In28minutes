package com.microservices;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
	
	Logger logg=(Logger) LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logg.info( "request ->{} request uri-> {}",request,request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
