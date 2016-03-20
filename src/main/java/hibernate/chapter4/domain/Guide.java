package hibernate.chapter4.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guide")
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "stuff_id")
    private String stuffId;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST})
    private Set<Student> students = new HashSet<>();

    public Guide(){}

    public Guide(String stuffId, Integer salary, String name) {
        this.stuffId = stuffId;
        this.salary = salary;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuffId() {
        return stuffId;
    }

    public void setStuffId(String stuffId) {
        this.stuffId = stuffId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setGuide(this);
    }
}
