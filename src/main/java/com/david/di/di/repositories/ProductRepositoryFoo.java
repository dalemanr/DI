package com.david.di.di.repositories;

import com.david.di.di.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("foo")
public class ProductRepositoryFoo implements IproductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitor",350L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id,"Monitor",350L);
    }
}
