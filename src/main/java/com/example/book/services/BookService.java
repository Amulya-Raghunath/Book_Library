package com.example.book.services;

import com.example.book.models.Book;
import com.example.book.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookrepo;
    //private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks()
    {
        return bookrepo.findAll();
    }
    public Optional<Book> getBookById(Long id)
    {
        return bookrepo.findById(id);
    }
    public Book saveBook(Book book)
    {
        return bookrepo.save(book);
    }
        public void deleteBooks(Long id)
    {
        bookrepo.deleteById(id);
    }
    public List <Book> getBookByTitle(String title)
    {
        return bookrepo.findByTitleIgnoreCase(title == null ? "" : title);
    }
    public List <Book> getBookByAuthor(String author)
    {
        return bookrepo.findByAuthorIgnoreCase(author == null ? "" : author);
    }
    public List <Book> getBookByTitleAndAuthor(String author,String title)
    {
        return bookrepo.findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author == null ? "" : author,title == null ? "" : title);
    }

}

