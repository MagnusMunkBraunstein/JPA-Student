package org.example.jpastudent.Repositories;

import org.example.jpastudent.Model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired StudentRepository studentRepository;

    //Unit Test



    // Test der tester om der er en tim i databasen
    // vi forventer at der er en
    // idet der er lavet en tim i init data
    @Test
    void testOneTim(){
        List<Student> lst = studentRepository.findAllByName("Tim");
        assertEquals(1,lst.size());
    }


}