package edu.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.model.Student;
import edu.spring.services.interfaces.IStudentService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
	@Autowired
	private IStudentService service;
	
	@GetMapping("/{id}")
	public Student retrieve(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping("")
	public List<Student> list() {
		return service.findAll();
	}
	

	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Student create(@RequestBody Student c) {		
		service.save(c);
		return c;
	}
	
	@PutMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Student update(@RequestBody Student c) {		 			
		service.save(c);
		return c;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
