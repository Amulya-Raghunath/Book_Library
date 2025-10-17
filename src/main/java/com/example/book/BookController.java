package com.example.book;

import com.example.book.models.Book;
import com.example.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    //private final List <Book> books= new ArrayList<>();

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String title,@RequestParam(required = false) String author,Model model)
    {
        List<Book> book;
        if((author ==null||author.isBlank())&&(title==null || title.isBlank())) {
            book = bookService.getAllBooks();
        }
        else if((author!=null || !author.isBlank())&&(title==null||title.isBlank()))
        {
            book=bookService.getBookByAuthor(author);
        }
        else if((author==null || author.isBlank())&&(title!=null||!title.isBlank()))
        {
            book=bookService.getBookByTitle(title);
        }
        else
        {
            book=bookService.getBookByTitleAndAuthor(author,title);
        }
        model.addAttribute("books",book);
        model.addAttribute("authorQuery",author==null?" ":author);
        model.addAttribute("titleQuery",title==null?" ":title);
        return "index";


    }

    public String homePage(Model model)
    {
        model.addAttribute("books",bookService.getAllBooks());
        return "index";
    }
    @GetMapping("/add")
    public String addBook(Model model)
    {
        model.addAttribute("book",new Book());
        return  "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBooks(id);
        return "redirect:/";
    }
}
