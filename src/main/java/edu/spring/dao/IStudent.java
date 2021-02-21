package edu.spring.dao;

import org.springframework.data.repository.CrudRepository;


import edu.spring.model.Student;


public interface IStudent extends CrudRepository<Student, Long> {
	
	public Student findByFirstName(String firtsName);
	
}
