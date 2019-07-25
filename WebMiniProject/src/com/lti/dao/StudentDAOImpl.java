package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.lti.bean.Student;

public class StudentDAOImpl  implements StudentDAO{
	private Connection con;

	@Override
	public boolean addStudent(Student ob) {
		boolean inserted=false;
		// Load Driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
				
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("insert into Student values(?,?,?,?,?)");
				ps1.setInt(1, ob.getRollno());
				ps1.setString(2, ob.getFname());
				ps1.setString(3,ob.getLname());
				ps1.setString(4, ob.getCourse());
				ps1.setString(5, ob.getResult());
			   
				int i=ps1.executeUpdate();
				System.out.println("Records inserted are: "+i);
				
				inserted=true; 
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
					inserted=false;
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return inserted;
	}

	@Override
	public boolean deleteStudent(Student ob) {
		// TODO Auto-generated method stub
		boolean inserted=false;
		// Load Driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
				
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("delete from student where rollno=?");
				ps1.setInt(1, ob.getRollno());
			/*ps1.setString(2, ob.getFname());
				ps1.setString(3,ob.getLname());
				ps1.setString(4, ob.getCourse());
				ps1.setString(5, ob.getResult());
			   */
				int i=ps1.executeUpdate();
				System.out.println("Records Deleted are: "+i);
				
				inserted=true; 
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
					inserted=false;
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return inserted;
	}

	@Override
	public boolean SearchStudent(int rollno) {
		boolean inserted=false;
		List<Student>acclist=new ArrayList<Student>();
		// Load Driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Establish connection using url, username and password
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		
		try
		{
		//establish connection
		con=DriverManager.getConnection(url,username,password);
		System.out.println("Connected");
		
		//parametrized query
		PreparedStatement ps1=con.prepareStatement("select * from student where rollno=?");
		ps1.setInt(1, rollno);
		ResultSet rs=ps1.executeQuery();
		Student ob = new Student();
		while(rs.next()) {
		ob.setRollno(rs.getInt(1));
		ob.setFname(rs.getString(2));
		ob.setLname(rs.getString(3));
		ob.setCourse(rs.getString(4));
		ob.setResult(rs.getString(5));
		
		acclist.add(ob);
		System.out.println(acclist);}
		inserted=true;
		
		}
		catch(SQLException e)
			{
			System.out.println(e.getMessage());
			inserted=false;
		
			}
		finally
		{
		try 
			{
			con.close();
			} 
		catch (SQLException e) 
			{
			e.printStackTrace();
			}	
		}
			return inserted;
	}

		@Override
	public boolean SearchStudentFail(String result) {
		boolean inserted=false;
		List<Student>acclist=new ArrayList<Student>();
		// Load Driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Establish connection using url, username and password
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="hr";
		String password="hr";
		
		try
		{
		//establish connection
		con=DriverManager.getConnection(url,username,password);
		System.out.println("Connected");
		
		//parametrized query
		PreparedStatement ps1=con.prepareStatement("select * from student where result=?");
		ps1.setString(1,result );
		ResultSet rs=ps1.executeQuery();
		
		
		while(rs.next()) 
		{
			Student ob = new Student();
		ob.setRollno(rs.getInt(1));
		ob.setFname(rs.getString(2));
		ob.setLname(rs.getString(3));
		ob.setCourse(rs.getString(4));
		ob.setResult(rs.getString(5));
		
		acclist.add(ob);
	
		
		}
		System.out.println(acclist);
		inserted=true;
		
		}
		catch(SQLException e)
			{
			System.out.println(e.getMessage());
			inserted=false;
		
			}
		finally
		{
		try 
			{
			con.close();
			} 
		catch (SQLException e) 
			{
			e.printStackTrace();
			}	
		}
			return inserted;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student>acclist=new ArrayList<Student>();
	
		// Load Driver
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// Establish connection using url, username and password
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="hr";
				String password="hr";
				
				try
				{
				//establish connection
				con=DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				
				//parametrized query
				PreparedStatement ps1=con.prepareStatement("select * from student");
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					Student ob = new Student();
				
					ob.setRollno(rs.getInt(1));
					ob.setFname(rs.getString(2));
					ob.setLname(rs.getString(3));
					ob.setCourse(rs.getString(4));
					ob.setResult(rs.getString(5));
					
					acclist.add(ob);
				
				}
				
				}
				catch(SQLException e)
					{
					System.out.println(e.getMessage());
				
					}
				finally
				{
				try 
					{
					con.close();
					} 
				catch (SQLException e) 
					{
					e.printStackTrace();
					}	
				}
		return acclist;
	}

}
