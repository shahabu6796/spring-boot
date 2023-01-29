package com.db.practice.SpringDbPractice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.practice.SpringDbPractice.entity.Student;
import com.db.practice.SpringDbPractice.service.StudentService;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping("/findstudent")
    public ResponseEntity<Student> getById(@RequestParam int id)
    {
        Student student = studentService.findById(id);
        return student == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.of(Optional.of(student));
    }

    @PostMapping("/save")
    public String save(@RequestBody Student student)
    {
        Student std = studentService.insertStudent(student);
        if (std != null)
        {
            return "your student data saved successfully";
        }
        else
        {
            return "some failure happened";
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> findAll()
    {
        List<Student> students = studentService.findAll();
        if (students.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(students));
        }
    }

    @GetMapping("/test")
    public String getAll()
    {
        return "testing purpose from student";
    }
}
