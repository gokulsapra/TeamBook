package com.springboot.TeamBook.dao;

import com.springboot.TeamBook.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //no need for any implementation class
    //handled by Spring Data JPA

}
