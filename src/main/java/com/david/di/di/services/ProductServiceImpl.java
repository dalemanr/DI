package com.david.di.di.services;

import com.david.di.di.models.Product;
import com.david.di.di.repositories.IproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IproductService {


    @Autowired
    Environment envi;

    @Autowired
    @Qualifier("productRepositoryJson")//qualifier para implementar un repositorio que no es el primario
    private IproductRepository repository;


    @Override
    public List<Product> findAll() {

        return repository.findAll().stream().map(p->{

            Double priceTax = p.getPrice() * envi.getProperty("val.tax", Double.class);// se puede el enviroment o el de el @value que a mi parecer es un poco mas simple y ordenado
            //Product newProd = new Product(p.getId(),p.getName(),priceImp.longValue());


            Product newProd = (Product) p.clone();// esta es una de las maneras correctas de hacer operaciones con un atributo de un objeto.
            //porque el objeto se guarda en memoria y al hacer transacciones sin cuidar este detalle, la transaccion se va a hacer cada vez que hagamos
            // la peticion en la vista o en cualquier otro lado, dando como resultado objetos con diferentes valores.
            newProd.setPrice(priceTax.longValue());
            return newProd;


             //p.setPrice(priceTax.longValue());
             //return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }


}
