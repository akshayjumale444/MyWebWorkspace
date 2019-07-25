package com.lti.service;

import java.util.List;

import com.lti.bean.Student;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao=new StudentDAOImpl();
	
	@Override
	public boolean addStudent(Student ob) {
		// TODO Auto-generated method stub
		return dao.addStudent(ob);
	}

	@Override
	public boolean deleteStudent(Student ob) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(ob);
	}

	@Override
	public boolean SearchStudent(int rollno) {
		// TODO Auto-generated method stub
		return dao.SearchStudent(rollno);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public boolean SearchStudentFail(String result) {
		// TODO Auto-generated method stub
		return dao.SearchStudentFail(result);
	}
	

}
