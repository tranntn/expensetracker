package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findDistinctByFirstName(String firstName);

    List<Student> findDistinctByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByLastNameLike(String lastName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Student> findByLastNameIn(List<String> lastName);

    List<Student> findFirst2ByOrderByEmailDesc();

    List<Student> findTop3ByOrderByLastNameAsc();

    @Query("SELECT s from Student s where s.firstName = ?1 or s.lastName = ?2")
    Student findStudentByFirstNameOrLastNameJPQLIndexedParam(String firstName, String lastName);

    @Query("SELECT s from Student s where s.firstName = :firstname or s.lastName = :lastName")
    Student findStudentByFirstNameOrLastNameJPQLNamedParam(@Param("firstName") String firstName,@Param("lastName") String lastName);

    @Query(value = "select * from students s where s.firstname = ?1 or s.lastName = ?2 ", nativeQuery = true)
    Student findStudentByFirstNameOrLastNameSQLIndexedParam(String firstName, String lastName);

    @Query(value = "select * from students s where s.firstName = :firstName or s.lastName= :lastName", nativeQuery = true)
    Student findStudentByFirstNameOrLastNameSQLNamedParam(@Param("firstName") String firstName,@Param("lastName") String lastName);


    @Query("SELECT s from Student s where s.firstName = ?1 and s.lastName =?2")
    Student findStudentByFirstNameAndLastNameJPQLIndexedParam(String firstName, String lastName);

    @Query("SELECT s from Student s where s.firstName=:firstName and s.lastName =:lastName")
    Student findStudentByFirstNameAndLastNameJPQLNamedParam(@Param("firstName") String firstName,@Param("lastName") String lastName);

    @Query(value = "select * from students s where s.firstName = ?1 and s.lastName = ?2", nativeQuery = true)
    Student findStudentByFirstNameAndLastNameSQLIndexedParam(String firstName, String lastName);

    @Query(value = "select * from students s where s.firstName =:firstName and s.lastName = :lastname", nativeQuery = true)
    Student findStudentByFirstNameAndLastNameSQLNamedParam(String firstName, String lastName);

}
