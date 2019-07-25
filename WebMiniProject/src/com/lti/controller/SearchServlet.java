package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String myroll=request.getParameter("rollno");
		int pmyroll=Integer.parseInt(myroll);
		
		
		StudentService service=new StudentServiceImpl();
		service.SearchStudent(pmyroll);
		out.println("Record Search Results");
		ServletContext application=getServletContext();
		List<Student> mylist=(List<Student>)application.getAttribute("acclist");
		
		for(Student o:mylist)
		{
			if(o.getRollno()==pmyroll)
			{
				out.println("Roll No.: "+o.getRollno());
				out.println("Fname: "+o.getFname());
				out.println("Lname: "+o.getLname());
				out.println("Course: "+o.getCourse());
				out.println("Result: "+o.getResult());
			}
		}
		
		
		application.setAttribute("acclist", mylist);
		//out.println("<a href='DisplayStudent.jsp'>Display Students</a>");
	}

}
