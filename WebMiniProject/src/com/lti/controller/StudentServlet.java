package com.lti.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lti.bean.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String s_rollno=request.getParameter("rollno");
			int myroll=Integer.parseInt(s_rollno);
			
			String s_fname=request.getParameter("fname");
			String s_lname=request.getParameter("lname");
			
			String s_course=request.getParameter("course");
			String s_result=request.getParameter("result");
			
			Student ob=new Student(myroll,s_fname,s_lname,s_course,s_result);
			StudentService service=new StudentServiceImpl();
			service.addStudent(ob);
			System.out.println("Student Data Inserted");
			
			ServletContext application=getServletContext();
			List<Student> mylist=(List<Student>)application.getAttribute("acclist");
			mylist.add(ob);
			application.setAttribute("acclist", mylist);
			
			request.setAttribute("myacc", ob);
			RequestDispatcher red=request.getRequestDispatcher("Success.jsp");
			red.forward(request, response);

		}
		catch(Exception e)
		{
			String error=e.getMessage();
			request.setAttribute("err", error);
			RequestDispatcher red=request.getRequestDispatcher("AddStudent.jsp");
			red.forward(request, response);
		}
	
	}

}
