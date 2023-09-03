package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class Save extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String[] courses = req.getParameterValues("course");
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Student Info:</h1>");
		writer.println("<h1>" + name + "</h1>");
		writer.println("<h1>" + email + "</h1>");
		writer.println("<h1>courses:<h1>");

		if (courses != null) {
			for (String course : courses) {
				writer.println("<h1>" + course + "</h1>");
			}
		} else {
			writer.println("<h1>no courses selected<h1>");
		}

	}
}
