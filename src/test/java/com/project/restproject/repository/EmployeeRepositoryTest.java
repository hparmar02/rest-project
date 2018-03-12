package com.project.restproject.repository;

import com.project.restproject.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave() throws Exception{
        Employee newEmployee = new Employee (1L, "testFirstName", "testLastName");

        Employee actualEmployee = employeeRepository.save(newEmployee);
        Assert.assertEquals(newEmployee, actualEmployee);
    }



    @Test
    public void testDelete() throws Exception{
        Employee newEmployee_1 = new Employee (2L, "testFirstName_1", "testLastName_1");

        employeeRepository.save(newEmployee_1);

        Optional<Employee> savedEmployee = employeeRepository.getByNumber(2L);
        Assert.assertEquals(newEmployee_1, savedEmployee.get());
        Long id = savedEmployee.get().getId();
        employeeRepository.deleteById(id);

        Optional<Employee> actualEmployee = employeeRepository.getByNumber(2L);
        Assert.assertFalse(actualEmployee.isPresent());

    }


    @Test
    public void testGet() throws Exception{
        Employee newEmployee_2 = new Employee (3L, "testFirstName_2", "testLastName_2");

        employeeRepository.save(newEmployee_2);
        Optional<Employee> actualEmployee = employeeRepository.getByNumber(3L);
        Assert.assertEquals(newEmployee_2, actualEmployee.get());
    }
}
