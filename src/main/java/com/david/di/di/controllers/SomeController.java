package com.david.di.di.controllers;

import com.david.di.di.models.Product;
import com.david.di.di.services.IproductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private IproductService productService;

    @GetMapping
    public List<Product> list(){
        return productService.findAll();

    }

    @GetMapping("/{id}")

    public Product show(@PathVariable Long id){
        return productService.findById(id);

    }
}
