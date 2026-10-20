//package com.springtest.demo.service;
//
//import com.springtest.demo.dao.EmployeeRepository;
//import com.springtest.demo.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceIMPL implements EmployeeService {
//
//    private EmployeeRepository employeeRepository;
//
//    public EmployeeServiceIMPL(EmployeeRepository theEmployeeRepository) {
//        employeeRepository = theEmployeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAllByOrderByLastNameAsc();
//    }
//
//    @Override
//    public Employee findById(int theId) {
//        Optional<Employee> result = employeeRepository.findById(theId);
//
//        Employee theEmployee = null;
//
//        if (result.isPresent()) {
//            theEmployee = result.get();
//        }
//        else {
//            // we didn't find the employee
//            throw new RuntimeException("Did not find employee id - " + theId);
//        }
//
//        return theEmployee;
//    }
//
//    @Override
//    public Employee save(Employee theEmployee) {
//        return employeeRepository.save(theEmployee);
//    }
//
//    @Override
//    public void deleteById(int theId) {
//        employeeRepository.deleteById(theId);
//    }
//}
