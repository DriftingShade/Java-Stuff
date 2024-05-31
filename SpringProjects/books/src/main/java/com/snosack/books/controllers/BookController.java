package com.snosack.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snosack.books.models.Book;
import com.snosack.books.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books/index.jsp";
	}
	
	@GetMapping("books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@RequestMapping("books/new")
	public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
	
	@PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
}
