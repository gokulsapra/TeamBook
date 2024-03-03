package com.springboot.TeamBook.service;

import com.springboot.TeamBook.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(int theId);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(int theId, EmployeeDTO updatedEmployeeDTO);

    void deleteById(int theId);

}
