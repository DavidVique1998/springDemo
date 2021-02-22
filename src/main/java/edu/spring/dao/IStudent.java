package edu.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import edu.spring.model.Student;


public interface IStudent extends CrudRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firtsName);
	public List<Student> findByLastName(String firtsName);
	
}
