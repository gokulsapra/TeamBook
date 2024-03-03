package com.springboot.TeamBook.rest;

import com.springboot.TeamBook.dto.EmployeeDTO;
import com.springboot.TeamBook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //adding employeeService dependency
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //REST endpoint that returns a list of employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll(){

        List<EmployeeDTO> employeeDTOs = employeeService.findAll();

        //creating and returning response entity with list of all employees in employeeDTOs as response body
        //and HTTP status code of 200 OK
        return ResponseEntity.ok(employeeDTOs);
    }

    //REST endpoint that returns a single employee with the given id
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int employeeId){

        EmployeeDTO employeeDTO = employeeService.findById(employeeId);

        //creating and returning response entity with employeeDTO as response body
        //and HTTP status code of 200 OK
        return ResponseEntity.ok(employeeDTO);
    }

    //REST endpoint that creates an employee in the database from the info passed in the request body
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO savedEmployeeDTO = employeeService.createEmployee(employeeDTO);

        //creating and returning response entity with savedEmployeeDTO as response body
        //and 201 as HTTP status code
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);

    }

    //REST endpoint that updates an existing employee in the database
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable int employeeId,
                                                      @RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployee(employeeId, employeeDTO);

        //creating and returning response entity with updatedEmployeeDTO as response body
        //and HTTP status code of 200 OK
        return ResponseEntity.ok(updatedEmployeeDTO);
    }

    //REST endpoint that deletes an existing employee from the database
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){

        employeeService.deleteById(employeeId);

        //creating and returning response entity with a message string as response body
        //and HTTP status code of 200 OK
        return ResponseEntity.ok("Successfully deleted employee with id: " + employeeId);
    }



}
