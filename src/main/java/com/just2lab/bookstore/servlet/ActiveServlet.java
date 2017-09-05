package com.just2lab.bookstore.servlet;


import com.just2lab.bookstore.exception.UserException;
import com.just2lab.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		String activeCode = request.getParameter("activeCode");
		
		UserService us = new UserService();
		try {
			us.activeUser(activeCode);
		} catch (UserException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
