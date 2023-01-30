package com.shastra.shastra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shastra.shastra.model.Student;

@Service
public interface Studentservice {

	Student addStudent(Student student);

	List <Student> getAllStudents();
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	 void deleteStudentById(Long id);
	 
	 List<Student> findPaginated(int pageNo,int pageSize);

}
