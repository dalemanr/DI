package com.david.di.di.services;

import com.david.di.di.models.Product;

import java.util.List;

public interface IproductService {

    List<Product> findAll();
    Product findById(Long id);
}
