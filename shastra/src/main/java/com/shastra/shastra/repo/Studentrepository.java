package com.shastra.shastra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shastra.shastra.model.Student;

@Repository
public interface Studentrepository extends JpaRepository<Student,Long>{

	
}
