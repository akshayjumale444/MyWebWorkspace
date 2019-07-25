package com.lti.dao;

import java.util.List;

import com.lti.bean.Student;

public interface StudentDAO 
{
	public boolean addStudent(Student ob);
	public boolean deleteStudent(Student ob);
	public boolean SearchStudent(int rollno);
	public boolean SearchStudentFail(String result);
	

	public List<Student>getAllStudent();

}
