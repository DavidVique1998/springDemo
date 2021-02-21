package edu.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> retrieve(@PathVariable(value="id") Long id) {
		try {
			Student p= service.findById(id);
			if(p!=null) {
				return ResponseEntity.ok(p);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> list() {
		try {
			List<Student> ps = service.findAll();
			if(!ps.isEmpty())
				return ResponseEntity.ok().body(ps);
			else
				return ResponseEntity.noContent().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	

	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Student c) {		
		try {
			service.save(c);
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Student c) {
		try {
			service.save(c);
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		try {
			service.delete(id);
			return ResponseEntity.accepted().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/firtsName/{firtsName}")
	public ResponseEntity<?> findByFirtsName(@PathVariable String firtsName) {
		
		try {
			Student ps = service.findByFirtsName(firtsName);
			if(ps!=null)
				return ResponseEntity.ok().body(ps);
			else
				return ResponseEntity.noContent().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/lastName/{lastName}")
	public ResponseEntity<?> findByLastName(@PathVariable String lastName) {
		
		try {
			Student ps = service.findByFirtsName(lastName);
			if(ps!=null)
				return ResponseEntity.ok().body(ps);
			else
				return ResponseEntity.noContent().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
