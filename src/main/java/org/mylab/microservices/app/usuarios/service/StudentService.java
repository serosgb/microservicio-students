package org.mylab.microservices.app.usuarios.service;

import java.util.Optional;

import org.mylab.microservices.app.usuarios.models.entity.Student;

public interface StudentService {

	Iterable<Student> findAll();

	Optional<Student> findById(Long id);

	Student save(Student student);

	void deleteById(Long id);

}