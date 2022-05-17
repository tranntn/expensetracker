package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("product", "product 2 description");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("product", "product 2 description");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(200));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(300));

        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("product");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("product 2");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(200), new BigDecimal(300));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        //start date
        LocalDateTime startDate = LocalDateTime.of(2022,05,17, 12,44,43);
        //end date
        LocalDateTime endDate = LocalDateTime.of(2022,5,17, 14,05,35);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("product 2", "product 1"));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findFirstByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findTop3ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }
}
