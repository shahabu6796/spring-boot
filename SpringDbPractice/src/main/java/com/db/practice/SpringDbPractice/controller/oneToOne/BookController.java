package com.db.practice.SpringDbPractice.controller.oneToOne;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.practice.SpringDbPractice.entity.oneToOne.Book;
import com.db.practice.SpringDbPractice.service.oneToOne.BookService;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    BookService bookService;

    @PostMapping("/save")
    public String save(@RequestBody Book book)
    {
        bookService.save(book);
        return "book and author data saved successfully";
    }

    @GetMapping("/getbook")
    public ResponseEntity<Book> findBook(@RequestParam int id)
    {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent())
        {
            return ResponseEntity.of(book);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getallbooks")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> books = bookService.findAllBooks();
        if (books.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(books));
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam int id)
    {
        bookService.deleteBookById(id);
        return id + " book id details deleted successfully..";
    }

    @DeleteMapping("/deleteall")
    public String deleteBooks()
    {
        bookService.deleteAll();
        return "All books record deleted successfully..";
    }
}
