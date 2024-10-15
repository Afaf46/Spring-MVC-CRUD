package com.example.Spring_MVC_CRUD;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //construction injection

    public EmployeeController (EmployeeService theemployeeservice){
        employeeService=theemployeeservice;
    }

    @GetMapping("/showlist")
    public String showlist (Model theModel){
        List<Employee> employee = employeeService.findAll();
        theModel.addAttribute("employee", employee);
        return "showemployee";
    }


    @GetMapping("/showform")
    public String showform (Model theModel){
        Employee employee = new Employee();
        theModel.addAttribute("employee",employee);
        return "Add";
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute("employee") Employee employee , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "Add";
        }else{
            employeeService.save(employee);

            // use redirect to prevent double submissions
            return "redirect:/showlist";

        }

    }

    @GetMapping("/update")
    public String showupdateform(@RequestParam("employeeId")int theId,Model theModel){
        // get employeeid from service

        Optional<Employee> theemployee = employeeService.findbyid(theId);
        // add it to the model to populate the form
        theModel.addAttribute("employee",theemployee);
        // return to the form
        return "Add";





    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int theId){

        employeeService.deletebyid(theId);
        return "redirect:/showlist";

    }
}
