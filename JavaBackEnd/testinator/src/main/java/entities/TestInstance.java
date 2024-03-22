package entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "test_instances")
public class TestInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testInstanceId;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "testTemplateId", referencedColumnName = "testTemplateId")
    private TestTemplate testTemplate;

    @OneToOne(mappedBy = "testInstance", cascade = CascadeType.ALL)
    private TestResult testResult;
}
