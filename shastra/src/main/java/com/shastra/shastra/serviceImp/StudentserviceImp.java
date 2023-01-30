package com.shastra.shastra.serviceImp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shastra.shastra.model.Student;
import com.shastra.shastra.repo.Studentrepository;
import com.shastra.shastra.service.Studentservice;

@Service
public class StudentserviceImp implements Studentservice {

	@Autowired
	 Studentrepository  studentRepo;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get() ;
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
      studentRepo.deleteById(id);		
	}

	@Override
	public List<Student> findPaginated(int pageNo,int pageSize) {

		Pageable paging=PageRequest.of(pageNo, pageSize);
		Page<Student> pagedResult=studentRepo.findAll(paging);
		return pagedResult.toList();
	}
	

}
