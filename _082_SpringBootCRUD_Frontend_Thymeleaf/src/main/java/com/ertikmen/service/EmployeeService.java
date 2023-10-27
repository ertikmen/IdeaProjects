package com.ertikmen.service;


import com.ertikmen.repository_dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;
}
