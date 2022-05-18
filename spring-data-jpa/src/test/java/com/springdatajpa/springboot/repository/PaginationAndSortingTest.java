package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination(){
        int pageNo = 0;
        int pageSize = 5;

        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(product -> {
            System.out.println(product);
        });

        //total pages
        int totalPages = page.getTotalPages();
        System.out.println("totalPages" + totalPages);

        //total elements
        long totalElements = page.getTotalElements();
        System.out.println("totalElements" + totalElements);

        //number of elements
        int numberOfElements = page.getNumberOfElements();
        System.out.println("numberOfElements" + numberOfElements);

        //size
        int size = page.getSize();
        System.out.println("Size" + size);

        //last
        boolean last = page.isLast();
        System.out.println("isLast" + last);

        //first
        boolean first = page.isFirst();
        System.out.println("isFirst" + first);
    }

    @Test
    void sorting(){
        String sortBy = "price";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);

        products.forEach(product -> {
            System.out.println(product);
        });
    }

    @Test
    void sortingByMultipleFields(){
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach(product -> {
            System.out.println(product);
        });
    }

    @Test
    void paginationAndSortingTogether(){
        String sortBy = "price";
        String sortDir = "desc";

        int pageNo = 0;
        int pageSize = 5;

        Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();
        products.forEach(product -> {
            System.out.println(product);
        });

        //total pages
        int totalPages = page.getTotalPages();
        System.out.println("totalPages" + totalPages);

        //total elements
        long totalElements = page.getTotalElements();
        System.out.println("totalElements" + totalElements);

        //number of elements
        int numberOfElements = page.getNumberOfElements();
        System.out.println("numberOfElements" + numberOfElements);

        //size
        int size = page.getSize();
        System.out.println("Size" + size);

        //last
        boolean last = page.isLast();
        System.out.println("isLast" + last);

        //first
        boolean first = page.isFirst();
        System.out.println("isFirst" + first);
    }
}
