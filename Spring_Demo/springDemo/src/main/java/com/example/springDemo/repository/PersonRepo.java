package com.example.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springDemo.entity.Person;

public interface PersonRepo extends JpaRepository<Person, String>{

}
