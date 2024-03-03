package com.springboot.TeamBook.service;

import com.springboot.TeamBook.dao.EmployeeRepository;
import com.springboot.TeamBook.dto.EmployeeDTO;
import com.springboot.TeamBook.entity.Employee;
import com.springboot.TeamBook.exceptions.ResourceNotFoundException;
import com.springboot.TeamBook.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    //injecting employeeRepository dependency
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> findAll() {

        List<Employee> employees = employeeRepository.findAll();

        //we have a list of employees jpa entities
        //we need it to convert it into a list of employeeDTO objects
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isEmpty()){
            //employee not found
            throw new ResourceNotFoundException("Did not find employee id - " + theId);

        }
        else{
            theEmployee = result.get();
        }

        return EmployeeMapper.mapToEmployeeDTO(theEmployee);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        //converting employeeDTO object into employee jpa entity object
        Employee theEmployee = EmployeeMapper.mapToEmployee(employeeDTO);

        //saving the employee object in the database
        Employee savedEmployee = employeeRepository.save(theEmployee);

        //returning saved employee's DTO object
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(int theId, EmployeeDTO updatedEmployeeDTO) {

        //new way introduced in java 8 to check if database returns null
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isEmpty()){
            //employee not found
            throw new ResourceNotFoundException("Did not find employee id - " + theId);
        }
        else{
            theEmployee = result.get();
        }

        //updating this employee with its new details
        theEmployee.setFirstName(updatedEmployeeDTO.getFirstName());
        theEmployee.setLastName(updatedEmployeeDTO.getLastName());
        theEmployee.setEmail(updatedEmployeeDTO.getEmail());

        //saving new information in the database
        Employee updatedEmployeeObj = employeeRepository.save(theEmployee);

        //returning EmployeeDTO object
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteById(int theId) {

        //new way introduced in java 8 to check if database returns null
        Optional<Employee> result = employeeRepository.findById(theId);

        if(result.isEmpty()){
            //employee not found
            throw new ResourceNotFoundException("Did not find employee id - " + theId);
        }

        //deletes the employee with given id from the database
        employeeRepository.deleteById(theId);

    }
}
