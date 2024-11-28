package org.example.jpastudent.Repositories;

import org.example.jpastudent.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByName(String name);



}
