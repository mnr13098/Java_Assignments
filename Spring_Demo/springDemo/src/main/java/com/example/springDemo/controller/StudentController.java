package com.example.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springDemo.entity.Student;
import com.example.springDemo.repository.StudentRepo;
import com.example.springDemo.services.StudentService;

@RestController
public class StudentController {
   @Autowired
    StudentService stuService;
   
   @PostMapping("/student/add")
	Student addStudent(@RequestBody Student stdd) {
		return stuService.addStudent(stdd);
	}
   
   @GetMapping("/{email}")
   public Student getStudentByEmail(@PathVariable String email) {
       return stuService.getStudentByEmail(email).orElse(null);
   }
   
   @GetMapping("/student/all")
   List<Student> getAllStudents(){
	   return stuService.getAllStudents();
   }
}
