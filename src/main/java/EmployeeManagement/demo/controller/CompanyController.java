package EmployeeManagement.demo.controller;

import EmployeeManagement.demo.model.Company;
import EmployeeManagement.demo.model.Employee;
import EmployeeManagement.demo.repository.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired(required = true)
    CompanyRepository companyRepository;

    @RequestMapping(value = "/detail/{id}")
    public String getCompanyById(@PathVariable(value="id") Long id, Model model) {
        Company company = companyRepository.getById(id);
        Set<Employee> employees = company.getEmployees();
        model.addAttribute("company", company);
        model.addAttribute("employees", employees);
        return "company/detail";
    }

    @RequestMapping(value="/")
    public String getAllCompany(Model model) {
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        return "company/list";
    }

    @RequestMapping(value="/create")
    public String createCompany(@Valid Company company, BindingResult result) {
        if (result.hasErrors()) {
            return "company/create";
        }
        companyRepository.save(company);
        return "redirect:/company/detail/" + company.getId();
    }

    @RequestMapping(value="/update/{id}")
    public String updateCompany(@PathVariable(value="id") Long id, Model model) {
        Company company = companyRepository.getById(id);
        model.addAttribute("company", company);
        return "company/update";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteCompany(@PathVariable(value="id") Long id) {
        companyRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value="/insert")
    public String insertCompany(Company company) {
        companyRepository.save(company);
        return "redirect:/detail/" + company.getId();
    }

    @RequestMapping(value = "/save")
    public String saveCompany(@Valid Company company, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "company/create";
        }
        companyRepository.save(company);
        return "redirect:/company/detail/" + company.getId();
    }
}
