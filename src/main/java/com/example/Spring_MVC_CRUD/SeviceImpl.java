package com.example.Spring_MVC_CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeviceImpl implements EmployeeService{

     private EmployeeRepo employeeRepo;


     @Autowired
public SeviceImpl (EmployeeRepo employeeRepo1){
    employeeRepo=employeeRepo1;
}


    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }
    @Override
    public Optional<Employee> findbyid(int id) {

        return employeeRepo.findById(id);
    }


    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }




    @Override
    public void deletebyid(int id) {
        employeeRepo.deleteById(id);
    }


}
