package com.project.restproject.service;


import com.project.restproject.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Employee actualEmployee = employeeService.get(1L);
        Assert.assertEquals(newEmployee, actualEmployee);
    }

    @Test
    public void testDelete() throws Exception{
        Employee newEmployee = new Employee(1L, "testFirstName", "testLastName");
        employeeService.save(newEmployee);

        Employee employeeSaved = employeeService.get(1L);
        Assert.assertEquals(newEmployee, employeeSaved);
        employeeService.delete(1L);

        Employee actualEmployee = employeeService.get(1L);
        Assert.assertNull(actualEmployee);

    }
}
