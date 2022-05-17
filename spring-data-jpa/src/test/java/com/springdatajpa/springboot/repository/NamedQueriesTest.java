package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){
        Product product = productRepository.findByPrice(new BigDecimal(100));
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void namedJPQLQueries(){
        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });

        Product product = productRepository.findByPrice(new BigDecimal(100));
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByDescription(){
        Product product = productRepository.findByDescription("product 2 description");
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
}
