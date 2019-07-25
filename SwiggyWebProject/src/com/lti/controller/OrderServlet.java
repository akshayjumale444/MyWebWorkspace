package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.bean.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet.view")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		/*String id=request.getParameter("pid");
		String name=request.getParameter("pname");
		String price=request.getParameter("pprice");
		String quantity=request.getParameter("pqty");
		double bill=Double.parseDouble(price)*Integer.parseInt(quantity);
		
		out.println("Product Id: "+id+"<br>");
		out.println("Name: "+name+"<br>");
		out.println("Price: "+price+"<br>");
		out.println("Quantity: "+quantity+"<br>");
		out.println("Total Bill: "+bill+"<br>");
		out.println("Method: "+request.getMethod());*/
		
		try
		{
			
			String s_pid=request.getParameter("pid");
			int mypid=Integer.parseInt(s_pid);
			
			String s_pname=request.getParameter("pname");
			
			String s_price=request.getParameter("price");
			double price=Double.parseDouble(s_price);
			
			String s_qn=request.getParameter("quantity");
			int qn=Integer.parseInt(s_qn);
			
			double bill=price*qn;
			Order ob=new Order(mypid,s_pname,price,qn);
			ob.setBill(bill);
			// code to keep data in a session
			HttpSession session=request.getSession();
			
			session.setAttribute("myorder", ob);
			
			response.sendRedirect("Bill.jsp");
		}
		catch(Exception e)
		{
			String error=e.getMessage();
			RequestDispatcher red=request.getRequestDispatcher("index.html");
			red.include(request, response);
			out.println("<font color=red size=4>"+error+"</font>");
			out.close();
		}
		
	}

}
