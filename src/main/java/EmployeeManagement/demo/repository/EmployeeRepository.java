package EmployeeManagement.demo.repository;

import EmployeeManagement.demo.model.Company;
import EmployeeManagement.demo.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
    Employee getById(Long id);
    List<Employee> findByCompany(Company company, Sort sort);
}
