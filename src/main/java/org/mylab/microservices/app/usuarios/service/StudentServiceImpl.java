package org.mylab.microservices.app.usuarios.service;

import java.util.Optional;

import org.mylab.microservices.app.usuarios.models.entity.Student;
import org.mylab.microservices.app.usuarios.models.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Iterable<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Student> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Student save(Student student) {
		return repository.save(student);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
