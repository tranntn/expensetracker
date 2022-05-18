package com.springdatajpa.springboot.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@NamedQueries({
        @NamedQuery(
                name="Student.findByFirstNameOrLastNameJPQL",
                query = "select s from Student s where s.firstName = :firstName or s.lastName = :lastName"
        )
})

@NamedNativeQueries({
        @NamedNativeQuery(
                name="Student.findByFirstNameOrLastNameSQL",
                query = "select * from students s where  s.first_name = :firstName and s.last_name = :lastName",
                resultClass = Student.class
        )
})

@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
