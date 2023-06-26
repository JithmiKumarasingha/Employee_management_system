package com.dailycodebuffer.employee.controller;

import com.dailycodebuffer.employee.model.Employee;
import com.dailycodebuffer.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000/")

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //define a method/api to handle the post request of the data is below
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee)
    {   //this returns the model object Employee(thats why the return type is Employee here)
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }
    @DeleteMapping("/employees/{id}")
 public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
boolean deleted = false;
deleted = employeeService.deleteEmployee(id);
 Map<String,Boolean>response = new HashMap<>();
   response.put("deleted",deleted);
   return ResponseEntity.ok(response);
    }
     @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
           return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employee){

     employee = employeeService.updateEmployee(id, employee);
     return ResponseEntity.ok(employee);

    }

}