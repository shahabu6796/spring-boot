package com.db.practice.SpringDbPractice.service.oneToOne;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.practice.SpringDbPractice.entity.oneToOne.Book;
import com.db.practice.SpringDbPractice.repository.oneToOne.BookRepository;

@Service
public class BookService
{
    @Autowired
    BookRepository bookRepository;

    public void save(Book book)
    {
        bookRepository.save(book);
    }

    public Optional<Book> findById(int id)
    {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }

    public void deleteBookById(int id)
    {
        bookRepository.deleteById(id);
    }

    public void deleteAll()
    {
        bookRepository.deleteAll();
    }
}
