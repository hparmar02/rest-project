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

    @Test
    public void testSave() throws Exception{
        Employee newEmployee = new Employee (1L, "firstNameTest", "lastNameTest");

        Employee actualEmployee = employeeService.save(newEmployee);
        Assert.assertEquals(newEmployee, actualEmployee);
    }



    @Test
    public void testDelete() throws Exception{
        Employee newEmployee = new Employee (2L, "firstNameTest_1", "lastNameTest_!");

        employeeService.save(newEmployee);

        Optional<Employee> savedEmployee = employeeService.get(2L);
        Assert.assertEquals(newEmployee, savedEmployee.get());
        Long id = savedEmployee.get().getId();
        employeeService.delete(id);

        Optional<Employee> actualEmployee = employeeService.get(2L);
        Assert.assertFalse(actualEmployee.isPresent());

    }


    @Test
    public void testGet() throws Exception{
        Employee newEmployee = new Employee (5L, "firstNameTest_2", "lastNameTest_2");

        employeeService.save(newEmployee);
        Optional<Employee> actualEmployee = employeeService.get(5L);
        Assert.assertEquals(newEmployee, actualEmployee.get());
    }
}
