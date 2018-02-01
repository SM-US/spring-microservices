package com.sumit.cloud;

import com.netflix.zuul.ZuulFilter;

public class CustomZuulFilter extends ZuulFilter {

	@Override
	public Object run() {
		System.out.println("Request has been routed thru custom filter of zuul!");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
