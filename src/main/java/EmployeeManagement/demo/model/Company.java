package EmployeeManagement.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;
    @Size(min = 3, max = 50)
    private String name;
    @NotEmpty
    private String image;
    @Length(min = 10, max = 100)
    private String address;
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }
}
