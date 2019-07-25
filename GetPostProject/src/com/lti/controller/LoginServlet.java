package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.bean.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.view")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //for get,doGet will be executed
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String us=request.getParameter("user");
		String pass=request.getParameter("pwd");
		
		if(us.equals("anu")&& pass.equals("lti"))
		{
			String myemail=us+"1234@lntinfotech.com";
			LoginUser myuser=new LoginUser();
			myuser.setEmail(myemail);
			myuser.setUsername(us);
			// setting data in request object by attribute name, actual object
			// set attribute 
			request.setAttribute("userdetails", myuser);
			
			//if the login is successful go to Bank.jsp
			//RequestDispatcher will hold the next page url
			RequestDispatcher red=request.getRequestDispatcher("Bank.jsp");
			red.forward(request, response);
		}
		else
		{
			//another way of generating RequestDispatcher is
			//Use ServletContext which represents web application environment
			ServletContext application=request.getServletContext();
			RequestDispatcher red=application.getRequestDispatcher("/index.html");
			red.include(request, response);
			
			out.println("<hr><font color=red size=4>UnAuthorized User</font>");
			out.close();
		}
		
		
		
	}



}
