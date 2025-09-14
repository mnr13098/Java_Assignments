package com.example.springDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springDemo.entity.Student;

@Service
public interface StudentService {


	Student addStudent(Student std);
	
	
	List<Student> getAllStudents();
	
	Optional<Student> getStudentByEmail(String email);
	
	
}
