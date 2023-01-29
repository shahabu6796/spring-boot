package com.db.practice.SpringDbPractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.practice.SpringDbPractice.entity.Student;
import com.db.practice.SpringDbPractice.repository.StudentRepository;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public Student insertStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student findById(int id)
    {
        return studentRepository.findById(id).isPresent() ? studentRepository.findById(id).get() : null;
    }

    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }
    public void deleteBookById(int id)
    {
        studentRepository.deleteById(id);
    }
    public void deleteAll()
    {
        studentRepository.deleteAll();
    }
}
