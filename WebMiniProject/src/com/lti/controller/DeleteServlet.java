package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.bean.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		Student ob=new Student(pmyroll,null,null,null,null);
		StudentService service=new StudentServiceImpl();
		service.deleteStudent(ob);
		out.println("Record Deleted");
		out.println("<a href='DisplayStudent.jsp'>Display Students</a>");
		
	}

}
