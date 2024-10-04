package com.david.di.di;

import com.david.di.di.repositories.IproductRepository;
import com.david.di.di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value="classpath:config.properties")
})
public class Confilg {


    @Bean
    public IproductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }

}
