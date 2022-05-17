package com.udemy.expensetrackerapi.controller;

import com.udemy.expensetrackerapi.entity.Expense;
import com.udemy.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable page){
        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam Long id){
         expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id){
       return expenseService.updateExpenseDetails(id, expense);
    }

    @GetMapping("/expenses/category")
    public List<Expense> getExpensesByCategory(@RequestParam String category, Pageable page){
        return expenseService.readByCategory(category, page);
    }

    @GetMapping("/expenses/name")
    public List<Expense> getExpensesByName(@RequestParam String keyword, Pageable page){
        return expenseService.readByName(keyword, page);
    }

    @GetMapping("/expenses/date")
    public List<Expense> getExpensesByDate(@RequestParam(required = false) Date startDate,
                                           @RequestParam(required = false) Date endDate,
                                           Pageable page){
      return expenseService.readByDate(startDate, endDate, page);
    }

    @GetMapping("/expenses/{name}/{category}")
    public List<Expense> getExpensesByNameOrCategory(@PathVariable String name, @PathVariable String category){
        return expenseService.readByNameOrCategory(name, category);
    }

    @DeleteMapping("/expenses/delete/{name}")
    public String deleteExpenseByName(@PathVariable String name){
        return expenseService.deleteByExpenseName(name) + " No. of records deleted";
    }
}
