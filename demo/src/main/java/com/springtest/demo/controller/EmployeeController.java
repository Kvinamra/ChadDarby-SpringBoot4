//package com.springtest.demo.controller;
//
//import com.springtest.demo.entity.Employee;
//import com.springtest.demo.service.EmployeeService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService theEmployeeService) {
//        employeeService = theEmployeeService;
//    }
//
//    @GetMapping("/list")
//    public String listEmployees(Model theModel) {
//        List<Employee> employeeList = employeeService.findAll();
//        theModel.addAttribute("employees", employeeList);
//        return "employees/list-employee";
//    }
//
//    @GetMapping("/showFormForAdd")
//    public String showFormForAdd(Model theModel) {
//        Employee theEmployee = new Employee();
//        theModel.addAttribute("employee", theEmployee);
//        return "employees/employee-form";
//    }
//
//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
//        employeeService.save(theEmployee);
//        return "redirect:/employees/list";
//    }
//
//    @GetMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
//        Employee theEmployee = employeeService.findById(theId);
//        theModel.addAttribute("employee", theEmployee);
//        return "employees/employee-form";
//    }
//
//    @GetMapping("/delete")
//    public String deleteEmployee(@RequestParam("employeeId") int theId) {
//        employeeService.deleteById(theId);
//        return "redirect:/employees/list";
//    }
//}
