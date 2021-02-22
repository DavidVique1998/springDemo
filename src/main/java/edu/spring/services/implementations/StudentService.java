package edu.spring.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.dao.IStudent;
import edu.spring.model.Student;
import edu.spring.services.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudent dao;
	@Override
	public void save(Student c) {
		try {
			dao.save(c);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Student findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		try {
			dao.deleteById(id);
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findAll() {
		return (List<Student>) dao.findAll();
	}

	@Override
	public List<Student>  findByFirtsName(String firtsName) {
		return dao.findByFirstName(firtsName);
	}

	@Override
	public List<Student>  findByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}

}
