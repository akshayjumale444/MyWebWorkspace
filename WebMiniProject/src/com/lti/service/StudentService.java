package com.lti.service;
import java.util.List;

import com.lti.bean.*;

public interface StudentService {
	public boolean addStudent(Student ob);
	public boolean deleteStudent(Student ob);
	public boolean SearchStudent(int rollno);
	public boolean SearchStudentFail(String result);
	
	public List<Student>getAllStudent();

}
