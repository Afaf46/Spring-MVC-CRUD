package com.example.Spring_MVC_CRUD;


import java.util.List;
import java.util.Optional;

public interface EmployeeService  {

    List<Employee> findAll();
    Optional<Employee> findbyid(int id);

    Employee save(Employee employee);
    void  deletebyid (int id);
}
