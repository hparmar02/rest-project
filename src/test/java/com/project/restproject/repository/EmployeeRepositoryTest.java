package com.project.restproject.repository;

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
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private  Employee newEmployee;

    @Before
    public void setUp(){
        newEmployee = new Employee(1L, "testFirstName", "testLastName");
    }

    @Test
    public void testSave() throws Exception{
        Employee actualEmployee = employeeRepository.save(newEmployee);
        Assert.assertEquals(newEmployee, actualEmployee);
    }


    @Test
    public void testGet() throws Exception{
        Employee newEmployee = new Employee(1L, "testFirstName", "testLastName");
        employeeRepository.save(newEmployee);
        Employee actualEmployee = employeeRepository.get(1L);
        Assert.assertEquals(newEmployee, actualEmployee);
    }

    @Test
    public void testDelete() throws Exception{
        Employee newEmployee = new Employee(1L, "testFirstName", "testLastName");
        employeeRepository.save(newEmployee);

        Employee employeeSaved = employeeRepository.get(1L);
        Assert.assertEquals(newEmployee, employeeSaved);
        employeeRepository.delete(1L);

        Employee actualEmployee = employeeRepository.get(1L);
        Assert.assertNull(actualEmployee);

    }
}
