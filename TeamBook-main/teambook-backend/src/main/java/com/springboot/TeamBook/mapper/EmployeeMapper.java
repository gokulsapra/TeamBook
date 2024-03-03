package com.springboot.TeamBook.mapper;

import com.springboot.TeamBook.dto.EmployeeDTO;
import com.springboot.TeamBook.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDTO(Employee employee){

        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){

        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );

    }
}
