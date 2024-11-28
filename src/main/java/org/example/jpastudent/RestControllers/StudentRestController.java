package org.example.jpastudent.RestControllers;


import org.example.jpastudent.Model.Student;
import org.example.jpastudent.Repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentRestController {
    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // her er et endpoint der kan kaldes fra en browser of vise alle Students
    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }


    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        // her laves en ny student ved navn std
        Student std = new Student();
        // her sættes student atributes
        std.setName("Mynte");
        std.setBornTime(LocalTime.now());
        //her gemmes den stpecifikke student
        studentRepository.save(std);

        // her laves en liste med navn lst
        List<Student> lst = new ArrayList<>();
        // her puttes alle students ned i lst
        lst = studentRepository.findAll();
        // lst retuneres
        return lst;
    }


    //Metode der finder Student ud fra navn
    // behov for at lave metode i student repository interface - se denne!

    // kan kaldes lokalt på http://localhost:8080/students/bjarne
    @GetMapping("/students/{name}")
    public List<Student> studentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }





}
