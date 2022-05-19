package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save product
        Product savedObject = productRepository.save(product);

        //display product information
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find or retrieve an entity by id
        Long id = 1L;
        Product product= productRepository.findById(id).get();

        //update entity information
        product.setName("updated product");
        product.setDescription("updated product 1 desc");

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;

        Product product= productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){

        //create product
        Product product2 = new Product();
        product2.setName("product 1");
        product2.setDescription("product 1 description");
        product2.setSku("500ABC");
        product2.setPrice(new BigDecimal(500));
        product2.setActive(true);
        product2.setImageUrl("product5.png");

        //create product
        Product product3 = new Product();
        product3.setName("product 2");
        product3.setDescription("product 2 description");
        product3.setSku("600ABC");
        product3.setPrice(new BigDecimal(600));
        product3.setActive(true);
        product3.setImageUrl("product6.png");

        Product product6 = new Product();
        product6.setName("product 3");
        product6.setDescription("product 3 description");
        product6.setSku("1200ABC");
        product6.setPrice(new BigDecimal(1200));
        product6.setActive(true);
        product6.setImageUrl("product12.png");

        //create product
        Product product7 = new Product();
        product7.setName("product 4");
        product7.setDescription("product 4 description");
        product7.setSku("1300ABC");
        product7.setPrice(new BigDecimal(300));
        product7.setActive(true);
        product7.setImageUrl("product13.png");

        //create product
        Product product8 = new Product();
        product8.setName("product 5");
        product8.setDescription("product 5 description");
        product8.setSku("1400ABC");
        product8.setPrice(new BigDecimal(300));
        product8.setActive(true);
        product8.setImageUrl("product14.png");

        Product product4 = new Product();
        product4.setName("product 6");
        product4.setDescription("product 6 description");
        product4.setSku("1500ABC");
        product4.setPrice(new BigDecimal(300));
        product4.setActive(true);
        product4.setImageUrl("product15.png");

        productRepository.saveAll(List.of(product2, product3, product6, product7, product4, product8));

    }

    @Test
    void findAllMethod(){

        List<Product> products = productRepository.findAll();
        products.forEach((product -> {
            System.out.println(product.getName());
        }));
    }

    @Test
    void deleteByIdMethod(){
        Long id = 3L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

       //find entity by id
       Long id = 2L;
       Product product = productRepository.findById(id).get();
       //delete(entity)
       productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        productRepository.deleteAll();

        Product product = productRepository.findById(8L).get();
        Product product2 = productRepository.findById(9L).get();

        productRepository.deleteAll(List.of(product, product2));

    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id = 10L;
        boolean isExist = productRepository.existsById(id);
        System.out.println(isExist);
    }
}