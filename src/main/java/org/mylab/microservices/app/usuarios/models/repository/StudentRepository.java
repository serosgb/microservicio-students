package org.mylab.microservices.app.usuarios.models.repository;

import org.mylab.microservices.app.usuarios.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
