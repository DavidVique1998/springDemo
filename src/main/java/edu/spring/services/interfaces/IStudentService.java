package edu.spring.services.interfaces;

import java.util.List;

import edu.spring.model.Student;


public interface IStudentService {
	public void save(Student c); //create-update
	public Student findById(Long id); //retrieve
	public void delete(Long id);	//delete
	public List<Student> findAll(); //list
	public Student findByFirtsName(String firtsName);// Get Student by firstName
	
	//new method

}
