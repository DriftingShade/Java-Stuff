package com.snosack.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snosack.bookclub.models.Book;
import com.snosack.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}