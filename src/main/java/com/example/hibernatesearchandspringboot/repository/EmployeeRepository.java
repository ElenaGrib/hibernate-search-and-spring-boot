package com.example.hibernatesearchandspringboot.repository;

import com.example.hibernatesearchandspringboot.model.Employee;
import org.springframework.data.repository.Repository;


public interface EmployeeRepository extends Repository<Employee, Long>, EmployeeRepositoryExt{
    Employee save(final Employee tweet);
}
