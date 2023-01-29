package com.db.practice.SpringDbPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.practice.SpringDbPractice.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>
{
}
