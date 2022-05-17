package com.udemy.expensetrackerapi.repository;

import com.udemy.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    //SELECT * FROM tabl_expenses WHERE category = ?
    Page<Expense> findByCategory(String category, Pageable page);

    //SELECT * FROM tbl_expenses WHERE name LIKE '%keyword%'
    Page<Expense> findByNameContaining(String keyword, Pageable page);

    //SELECT * FROM tbl_expenses WHERE data BETWEEN 'startDate' AND 'endDate'
    Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);

    @Query("FROM Expense WHERE name = :name OR category = :category")
    List<Expense> getExpenseByAmountAndName(String category, String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Expense WHERE name = :name")
    Integer deleteExpenseByName(String name);
}
