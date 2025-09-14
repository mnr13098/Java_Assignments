package com.example.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springDemo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String>{
      
	
}
