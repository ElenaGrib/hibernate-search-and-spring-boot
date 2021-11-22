package com.example.hibernatesearchandspringboot.controller;
import java.util.List;

import com.example.hibernatesearchandspringboot.model.Employee;
import com.example.hibernatesearchandspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private EmployeeRepository repository;

    @RequestMapping(value = "/")
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<Employee> searchResults = null;
        try {
            searchResults = repository.search(q);

        } catch (Exception ex) {
            // Nothing
        }
        model.addAttribute("search", searchResults);
        return "index";

    }
}
