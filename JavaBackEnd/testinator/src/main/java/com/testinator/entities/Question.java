package com.testinator.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
    private Teacher teacher;

    // Assuming questions can belong to multiple TestTemplates
    @ManyToMany(mappedBy = "questions")
    private Set<TestTemplate> testTemplates;
}
