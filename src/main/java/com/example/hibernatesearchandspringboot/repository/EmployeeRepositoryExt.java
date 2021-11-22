package com.example.hibernatesearchandspringboot.repository;

import com.example.hibernatesearchandspringboot.model.Employee;

import java.util.List;

public interface EmployeeRepositoryExt {
    List<Employee> search(final String keywords);
}
