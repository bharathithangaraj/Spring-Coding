package com.sunitkatkar.blogspot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sunitkatkar.blogspot.model.Employee;
import com.sunitkatkar.blogspot.service.EmployeeService;

@Controller
public class IndexController {

    @Autowired
    EmployeeService empService;

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = empService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee) {
    	
    	System.out.println("hello :::::::: "+employee.getSensitiveData());
        empService.save(employee);
        return "redirect:/";
    }
}
