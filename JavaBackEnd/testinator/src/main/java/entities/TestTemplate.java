package entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "test_templates")
public class TestTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testTemplateId;

    @ManyToMany
    @JoinTable(name = "template_question", joinColumns = @JoinColumn(name = "testTemplateId"), inverseJoinColumns = @JoinColumn(name = "questionId"))
    private Set<Question> questions;

    @OneToMany(mappedBy = "testTemplate", cascade = CascadeType.ALL)
    private Set<TestInstance> testInstances;
}
