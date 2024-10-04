package com.david.di.di.repositories;

import com.david.di.di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

@Primary
//@SessionScope// esta es para cuando queremos matar la session y no el objeto en concreto y se usa principalmente en web y no en apis, aunque tambien sirve para algunas cosas.
//@RequestScope// cuando queremos que el objeto construido se destruya al finalizar el proceso, parecido a la forma que teniamos en el servicio, pero si matamos el objeto principal por cada peticion, en cambio con la otra forma no matabamos.
@Repository
public class ProductRepositoryImpl  implements IproductRepository{

    List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L,"memoria",300L),
                new Product(2L,"mouse",1200L),
                new Product(3L, "teclado 60%",200L),
                new Product(4L,"mother",300L)
        );
    }


    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
