package org.mylab.microservices.app.usuarios.controllers;

import java.util.Date;
import java.util.Optional;

import org.mylab.microservices.app.usuarios.models.entity.Student;
import org.mylab.microservices.app.usuarios.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public ResponseEntity<?> getStudents() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Long id) {
		Optional<Student> optional = service.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(optional.get());
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student studentPersisted = service.save(student);

		return ResponseEntity.status(HttpStatus.CREATED).body(studentPersisted);
	}

	@PutMapping(value = "/{id", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
		Optional<Student> optional = service.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Student studentPersisted = optional.get();

		studentPersisted.setName(student.getName());
		studentPersisted.setLastname(student.getLastname());
		studentPersisted.setEmail(student.getEmail());
		studentPersisted.setUpdatedAt(new Date());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentPersisted));
	}

	@DeleteMapping("/{id")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
