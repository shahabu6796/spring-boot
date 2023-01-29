package com.db.practice.SpringDbPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.db.practice.SpringDbPractice.entity.Student;
import com.db.practice.SpringDbPractice.service.StudentService;

@SpringBootApplication
public class SpringDbPracticeApplication
{

    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(SpringDbPracticeApplication.class, args);
        StudentService bean = context.getBean(StudentService.class);
//        bean.insertStudent(new Student(3788, "Shahab"));
        //        bean.insertStudent(new Student(3523, "Ansari"));
        //        bean.insertStudent(new Student(4675, "Uddin"));
        //        bean.insertStudent(new Student(46332, "Raju"));
        //        bean.insertStudent(new Student(1111, "Rani"));
        //        bean.insertStudent(new Student(35453, "Rahul"));
        //        bean.insertStudent(new Student(24667, "Mohit"));
        //        bean.insertStudent(new Student(10000, "Great"));
    }
}
