package com.lti.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import com.lti.bean.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchFailedStudentListServlet
 */
@WebServlet("/SearchFailedStudentListServlet")
public class SearchFailedStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFailedStudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String list=request.getParameter("List");
		
		ServletContext application=getServletContext();
		List<Student> fs_list=(List<Student>)application.getAttribute("acclist");
		
		for(Student o:fs_list)
		{
			if(o.getResult().equalsIgnoreCase(list))
			{
				out.println("RollNo:"+o.getRollno()+"<br>");
				out.println("FirstName:"+o.getFname()+"<br>");
				out.println("LastName:"+o.getLname()+"<br>");
				out.println("Course:"+o.getCourse()+"<br>");
				out.println("<hr>");
			}
		}
	}

}
