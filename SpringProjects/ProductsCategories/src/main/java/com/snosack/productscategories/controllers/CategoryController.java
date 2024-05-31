package com.snosack.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snosack.productscategories.models.Category;
import com.snosack.productscategories.models.Product;
import com.snosack.productscategories.repositories.CategoryRepository;
import com.snosack.productscategories.repositories.ProductRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "newCategory.jsp";
    }

    @PostMapping("/categories/new")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/";
    }

    @GetMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
        Category category = categoryRepository.findById(id).orElse(null);
        model.addAttribute("category", category);
        model.addAttribute("products", productRepository.findAll());
        return "categoryPage.jsp";
    }

    @PostMapping("/categories/{id}/addProduct")
    public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("productId") Long productId) {
        Category category = categoryRepository.findById(id).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        category.getProducts().add(product);
        categoryRepository.save(category);
        return "redirect:/categories/" + id;
    }
}