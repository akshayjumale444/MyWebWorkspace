package com.lti.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import com.lti.bean.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

/**
 * Application Lifecycle Listener implementation class StudentListener
 *
 */
@WebListener
public class StudentListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StudentListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("CONTEXT INITIALIZED");
    	StudentService service=new StudentServiceImpl();
    	List<Student> alist=service.getAllStudent(); 
    	
    	ServletContext application=arg0.getServletContext();
    	application.setAttribute("acclist", alist);
    	
    }
	
}
