package com.javaguides.springboot.repository;

import com.javaguides.springboot.model.Employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    //JUnit test for save employee operation
    @DisplayName("JUnit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Tran")
                .lastName("Nguyen")
                .email("tranntn@gmail.com")
                .build();

        //when - action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.save(employee);

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    //JUnit test for get all employees operation
    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenEmployeeList_whenFindAll_thenEmployeeList() {
        // given - precondition or setup
        Employee employee1 = Employee.builder()
                .firstName("Tran")
                .lastName("Nguyen")
                .email("tranntn269@gmail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("Tung")
                .lastName("Bui")
                .email("tungbui@gmail.com")
                .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        //when - action or the behaviour that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        //then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    //JUnit test for get employee by id operation
    @Test
    public void given_when_then() {
        // given - precondition or setup
        Employee employee= Employee.builder()
                .firstName("Tran")
                .lastName("Nguyen")
                .email("tranntn269@gmail.com")
                .build();

        employeeRepository.save(employee);
        //when - action or the behaviour that we are going to test

        //then - verify the output
    }


}
