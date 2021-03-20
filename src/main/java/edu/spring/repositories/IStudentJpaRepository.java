package edu.spring.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.spring.model.Student;
public interface IStudentJpaRepository extends JpaRepository<Student, Long>{
	public List<Student> findByFirstName(String firstName);
	Page<Student> findByLastName(String criteria, Pageable pageable);
}
