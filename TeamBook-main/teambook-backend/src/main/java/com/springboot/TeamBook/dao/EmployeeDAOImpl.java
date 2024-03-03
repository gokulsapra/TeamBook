//package com.springboot.TeamBook.dao;
//
//import com.springboot.TeamBook.entity.Employee;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeDAOImpl implements EmployeeDAO{
//
//    private EntityManager entityManager;
//
//    @Autowired
//    public EmployeeDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//
//        //create query
//        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
//
//        //execute query and get result list
//        List<Employee> employees = theQuery.getResultList();
//
//        //return the result list
//        return employees;
//    }
//
//    @Override
//    public Employee findById(int theId) {
//
//        //get the employee by id
//        Employee theEmployee = entityManager.find(Employee.class, theId);
//
//        //return the employee
//        return theEmployee;
//    }
//
//    @Override
//    public Employee save(Employee theEmployee) {
//
//        //save or update the employee (depends on the id)
//        Employee dbEmployee = entityManager.merge(theEmployee);
//
//        //return the saved or updated employee
//        return dbEmployee;
//    }
//
//    @Override
//    public void deleteById(int theId) {
//
//        //find the employee by id
//        Employee theEmployee = entityManager.find(Employee.class, theId);
//
//        //delete the employee
//        entityManager.remove(theEmployee);
//
//    }
//}
