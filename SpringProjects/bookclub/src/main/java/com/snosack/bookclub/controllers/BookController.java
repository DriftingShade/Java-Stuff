package com.snosack.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snosack.bookclub.models.Book;
import com.snosack.bookclub.models.User;
import com.snosack.bookclub.services.BookService;
import com.snosack.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	BookService bookServ;
	
	@GetMapping("/addbook")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userServ.findUser(userId);
		model.addAttribute("user", user);
		model.addAttribute("book", book);
		return "create.jsp";
	}
	
	@PostMapping("/createbook")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User user = userServ.findUser(userId);
			model.addAttribute("user", user);
			model.addAttribute("book", book);
			return "create.jsp";
		} else {
			User user = userServ.findUser(userId);
			book.setUser(user);
			bookServ.createBook(book);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/books/{bookId}")
	public String view(Model model, @PathVariable("bookId") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userServ.findUser(userId);
		model.addAttribute("user", user);
		Book book = bookServ.findBook(id);
		model.addAttribute("book", book);
		return "view.jsp";
	}
	
	@GetMapping("/books/{bookId}/edit")
	public String edit(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userServ.findUser(userId);
		model.addAttribute("user", user);
		Book book = bookServ.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/books/{bookId}", method=RequestMethod.PUT)
	public String update(@PathVariable("bookId") Long bookId, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			User user = userServ.findUser(userId);
			model.addAttribute("user", user);
			model.addAttribute("book", book);
			return "edit.jsp";
		} else {
			User user = userServ.findUser(userId);
			book.setUser(user);
			book.setId(bookId);
			bookServ.updateBook(book);
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/books/{bookId}/delete", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("bookId") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/home";
	}

}