package com.interface21.sample.multiplecontexts.web1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.interface21.sample.multiplecontexts.service.SampleService;

/**
 * Servlet implementation class for Servlet: FirstServlet
 *
 */
 public class FirstServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// For this sample, we simply perform depency lookup from the current WebApplicationContext. 
		// This will query the shared parent context and find the sampleService bean.
		// In a real web app, Spring provide a better way to do dependency injection
		// of your web controllers/actions/whatever your web framework calls them.
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		SampleService service = (SampleService) ctx.getBean("sampleService");
		
		response.getWriter().println(service.sayHello("SampleWeb1") + " using service instance " + service);
	}
	
}