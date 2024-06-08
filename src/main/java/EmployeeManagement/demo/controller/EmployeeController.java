package EmployeeManagement.demo.controller;

import EmployeeManagement.demo.model.Company;
import EmployeeManagement.demo.model.Employee;
import EmployeeManagement.demo.repository.CompanyRepository;
import EmployeeManagement.demo.repository.EmployeeDao;
import EmployeeManagement.demo.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController  {
    @Autowired(required = true)
    EmployeeRepository employeeRepository;
    @Autowired(required = true)
    CompanyRepository companyRepository;
    @Autowired(required=true)
    EmployeeDao employeeDao;

    @GetMapping(value = "/list")
    public String getAllEmployee(
            @RequestParam(value = "company", required = false, defaultValue = "0") Long
                    comId,
            @RequestParam(value = "gender", required = false, defaultValue = "0") int
                    gender,
            @RequestParam(value = "sort", required = false, defaultValue = "0") int
                    sortMode,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            Model model) {

        final int pageSize = 1;

        model.addAttribute("comId", comId);
        model.addAttribute("gender", gender);
        model.addAttribute("sortMode", sortMode);
        Page<Employee> employees = employeeDao.filterAndSortEmployees(comId, gender, sortMode, PageRequest.of(page, pageSize));
        model.addAttribute("page", page);
        model.addAttribute("pages", employees.getTotalPages());
        model.addAttribute("employees", employees);
        model.addAttribute("companies", companyRepository.findAll());
        return "employee/list";
    }

    @RequestMapping(value="/detail/{id}")
    public String getEmployeeById(@PathVariable(value="id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    @RequestMapping(value="/update/{id}")
    public String updateEmployee(@PathVariable(value="id") Long id, Model model) {
        Employee employee = employeeRepository.getById(id);
        model.addAttribute("employee", employee);
        return "employee/update";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteEmployee(@PathVariable(value="id") Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/save")
    public String saveUpdate(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee/update";
        }
        employeeRepository.save(employee);
        return "redirect:/employee/update/" + employee.getId();
    }

    @RequestMapping(value="/create")
    public String createEmployee(Model model) {
        Employee employee = new Employee();
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        model.addAttribute("employee", employee);
        return "employee/create";
    }

    @RequestMapping(value="/insert")
    public String insertEmployee(@Valid Employee employee, BindingResult result) {
        if (employee.getCompany() != null) {
            Company company = companyRepository.getById(employee.getCompany().getId());
            employee.setCompany(company);
        }

        if (result.hasErrors()) {
            return "employee/create";
        }

        employeeRepository.save(employee);
        return "redirect:/employee/detail/" + employee.getId();
    }
}
