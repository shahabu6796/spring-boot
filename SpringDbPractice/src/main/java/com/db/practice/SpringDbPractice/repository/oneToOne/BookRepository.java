package com.db.practice.SpringDbPractice.repository.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.practice.SpringDbPractice.entity.oneToOne.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{
}
