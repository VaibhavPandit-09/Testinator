package com.testinator.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*
Student

- Attributes: StudentID, UserID, GradeLevel, PreferredSubjects
- Relationships:
    - One-to-One with `User`
    - One-to-Many with `TestInstance`
    - One-to-Many with `TestResult`
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private String GradeLevel;
    private String PreferredSubjects;
}
