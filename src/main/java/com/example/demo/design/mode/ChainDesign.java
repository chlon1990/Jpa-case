package com.example.demo.design.mode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ChainDesign implements FilterChain {

	private List<Filter> additionalFilters;
	private int size;
	private int currentPosition = 0;

	ChainDesign(List<Filter> filters) {
		this.additionalFilters = filters;
		this.size = filters.size();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		if (currentPosition == size) {
			System.out.println("链末尾了。。");
		} else {
			currentPosition++;
			Filter filter = additionalFilters.get(currentPosition - 1);
			filter.doFilter(request, response, this);

		}
	}

	public static void main(String[] args) throws Exception, Exception {
		List<Filter> filters = new ArrayList<Filter>();

		filters.add(new Filter() {

			@Override
			public void init(FilterConfig filterConfig) throws ServletException {
				// TODO Auto-generated method stub

			}

			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				System.out.println("第 1 条链。。。");
				chain.doFilter(request, response);
			}

			@Override
			public void destroy() {
				// TODO Auto-generated method stub

			}

		});
		
		filters.add(new Filter() {
			
			@Override
			public void init(FilterConfig filterConfig) throws ServletException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				System.out.println("第 2 条链。。。");
				//chain.doFilter(request, response);
			}
			
			@Override
			public void destroy() {
				// TODO Auto-generated method stub
				
			}
			
		});

		ChainDesign chain = new ChainDesign(filters);
		chain.doFilter(null, null);
	}

}
