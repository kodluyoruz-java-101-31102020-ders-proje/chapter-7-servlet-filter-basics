package com.servlets.basics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PingPongServlet extends HttpServlet {

	private static final long serialVersionUID = 4314064059533394383L;
	
	public int counter;
	
	
	@Override
	public void init() throws ServletException {
		
		counter = 0;
		System.out.println("PingPongServlet is initialized!");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().write("Request accepted! Server Response is 'Pong' ");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		synchronized (PingPongServlet.class) {
			counter++;
		}
		
		resp.getWriter().write("Http Post Counter: " + counter);
	}
	
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().write("PingPongServlet is up!");
	}
	
	@Override
	public void destroy() {
		
		counter = 0;
		System.out.println("Good bye!");
	}
}
