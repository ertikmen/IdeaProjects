package com.ertikmen.controller;


import com.ertikmen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public String getAllEmployees(){
        return "";
    }

}
