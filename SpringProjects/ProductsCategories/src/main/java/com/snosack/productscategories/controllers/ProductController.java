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
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "newProduct.jsp";
    }

    @PostMapping("/products/new")
    public String createProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryRepository.findByProductsNotContains(product));
        return "productPage.jsp";
    }

    @PostMapping("/products/{id}/addCategory")
    public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("categoryId") Long categoryId) {
        Product product = productRepository.findById(id).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);
        product.getCategories().add(category);
        productRepository.save(product);
        return "redirect:/products/" + id;
    }
}