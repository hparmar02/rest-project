package com.project.restproject.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;


/**
 * <h1>Model for Employee</h1>
 * <p>*
 * @author  Hiren Parmar
 * @version 1.0
 * @since   2018-03-04
 */

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Id of the Employee")
    private Long id;

    @ApiModelProperty(notes = "FirstName of the Employee")
    private String firstName;

    @ApiModelProperty(notes = "LastName of the Employee")
    private String lastName;

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee: [id: "+ id + " , FirstName: " + firstName + " , LastName: " + lastName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }
}
