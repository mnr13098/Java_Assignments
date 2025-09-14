package com.example.springDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springDemo.entity.Student;
import com.example.springDemo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	public Student addStudent(Student stdd) {
		return studentRepo.save(stdd);
	}
	
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public Optional<Student> getStudentByEmail(String email){
		return studentRepo.findById(email);
	}
}
