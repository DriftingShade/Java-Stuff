package com.snosack.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.snosack.books.models.Book;
import com.snosack.books.repositories.BookRepository;

@Service
public class BookService {
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
// Updates A Book
 public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if (optionalBook.isPresent()) {
         Book book = optionalBook.get();
         book.setTitle(title);
         book.setDescription(description);
         book.setLanguage(language);
         book.setNumberOfPages(numOfPages);
         return bookRepository.save(book);
     } else {
         return null;
     }
 }
//Deletes a book
 public void deleteBook(Long id) {
     bookRepository.deleteById(id);
 }
 
 public List<Book> booksContaining(String search) {
	 return bookRepository.findByDescriptionContaining(search);
 }
}


