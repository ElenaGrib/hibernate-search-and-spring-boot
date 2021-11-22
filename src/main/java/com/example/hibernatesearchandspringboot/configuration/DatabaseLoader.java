package com.example.hibernatesearchandspringboot.configuration;

import com.example.hibernatesearchandspringboot.model.Employee;
import com.example.hibernatesearchandspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {
    private final EmployeeRepository repository;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Иван", "Иванов"));
        this.repository.save(new Employee("Петр", "Петров"));
        this.repository.save(new Employee("Семен", "Семенов"));
        this.repository.save(new Employee("Алексей", "Алексеев"));
        this.repository.save(new Employee("Михаил", "Михайлов"));
    }
}
