package com.project.restproject.service;


import com.project.restproject.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    private Employee newEmployee;

    @Before
    public void setUp(){
        newEmployee = new Employee(1L, "testFirstName", "testLastName");
    }

    @Test
    public void testSave() throws Exception{
        Employee actualEmployee = employeeService.save(newEmployee);
        Assert.assertEquals(newEmployee, actualEmployee);
    }


    @Test
    public void testGet() throws Exception{
        Employee newEmployee = new Employee(1L, "testFirstName", "testLastName");
        employeeService.save(newEmployee);
        Optional<Employee> actualEmployee = employeeService.get("testFirstName");
        Assert.assertEquals(newEmployee, actualEmployee.get());
    }

    @Test
    public void testDelete() throws Exception{
        Employee newEmployee = new Employee(1L, "testFirstName", "testLastName");
        employeeService.save(newEmployee);

        Optional<Employee> employeeSaved = employeeService.get("testFirstName");
        Assert.assertEquals(newEmployee, employeeSaved.get());
        employeeService.delete(1L);

        Optional<Employee> actualEmployee = employeeService.get("testFirstName");
        Assert.assertFalse(actualEmployee.isPresent());

    }
}
