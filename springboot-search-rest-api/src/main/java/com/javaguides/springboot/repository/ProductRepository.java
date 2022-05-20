package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where " +
            "p.name like concat('%',:query, '%')" +
            "or p.description like concat('%', :query, '%')")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * FROM products p WHERE p.name like concat('%', :query, '%') or p.description like concat('%', :query, '%') ", nativeQuery = true)
    List<Product> searchProductsSQL(String query);
}
