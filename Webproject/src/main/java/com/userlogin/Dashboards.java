package com.userlogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dashboards")
public class Dashboards extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
	  response.setContentType("text/html");
	  String username=request.getParameter("username");
	  String password=request.getParameter("password");
	  RequestDispatcher rd=null;
		if(username!=null && username.equalsIgnoreCase("vinyas") 
		&& password!=null && password.equalsIgnoreCase("gowda"))
		{
			rd=request.getRequestDispatcher("Welcome");
			rd.forward(request, response);}
		else{
				rd=request.getRequestDispatcher("index5.html");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				out.print("<center><span style='color:green'>INVALID DATA!!</span></center>");
			}
		String url=request.getRequestURI().toString();
		PrintWriter pw=response.getWriter();
		pw.print("<center><h4><a href=Logout?>logout</a></h4></center>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
