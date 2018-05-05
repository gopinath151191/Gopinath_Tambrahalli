package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.EmployeeRepository;
import com.example.demo.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeData;

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
    public void newEmployee(@RequestBody Employee employee) {

        employeeData.save(employee);
    }

    /*@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.GET)
    public ModelAndView addNewEmployee() {

        Employee emp = new Employee();
        return new ModelAndView("newEmployee", "form", emp);

    }
*/
    @RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
    public List<Employee> employees() {
        List<Employee> allEmployees = employeeData.findAll();
        return allEmployees;

    }

}