package entities;

import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*
Teacher
- Attributes: teacherId, UserID, SubjectsQualifiedToTeach, Qualifications
- Relationships:
- One-to-One with `User`
- One-to-Many with `Question`
 */
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Question> questions;

}
