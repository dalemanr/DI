package com.david.di.di.repositories;

import com.david.di.di.models.Product;

import java.util.List;

public interface IproductRepository {
    List<Product> findAll();
    Product findById (Long id);
}
