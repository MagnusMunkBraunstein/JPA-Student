package org.example.jpastudent.Config;

import org.example.jpastudent.Model.Student;
import org.example.jpastudent.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner{


    @Autowired
    private StudentRepository studentRepository;

    // This line of code can be generated
    // in the commandlinerunner interface there is only one method and that is run()
    // this adds the two students to the mysql database
    @Override
    public void run(String... args) throws Exception {
        Student s1=new Student();
        s1.setName("Bruce");
        s1.setBornDate(LocalDate.of(2010,11,12));
        s1.setBornTime(LocalTime.of(10,11,12));
        studentRepository.save(s1);

        // Ligegyldigt med at gemme igen da s1 har id 1 og dermed ikke kan gemmes igen.
        studentRepository.save(s1);
        s1.setName("Bjarne");
        studentRepository.save(s1);


        Student s2=new Student();
        s2.setName("Adolf");
        s2.setBornDate(LocalDate.of(1800,1,2));
        s2.setBornTime(LocalTime.of(18,41,20));
        studentRepository.save(s2);

        Student s3 = new Student();
        s3.setName("Tim");
        s3.setBornDate(LocalDate.of(1800,1,2));
        s3.setBornTime(LocalTime.of(18,41,20));
        studentRepository.save(s3);

    }


}
