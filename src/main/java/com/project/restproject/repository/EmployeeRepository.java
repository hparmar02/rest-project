package com.project.restproject.repository;

import com.project.restproject.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * <h1>Repository for Employee Information</h1>
 * The Employee Repository implements methods to
 * save, get, delete an Employee
 * <p>*
 * @author  Hiren Parmar
 * @version 1.0
 * @since   2018-03-04
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> getByNumber(Long number);
}
