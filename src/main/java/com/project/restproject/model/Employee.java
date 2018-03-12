package com.project.restproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


/**
 * <h1>Model for Employee</h1>
 * <p>*
 * @author  Hiren Parmar
 * @version 1.0
 * @since   2018-03-04
 */

@Entity
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @ApiModelProperty(notes = "FirstName of the Employee")
    @Column(name = "number")
    private long number;


    @ApiModelProperty(notes = "FirstName of the Employee")
    @Column(name = "firstName")
    private String firstName;



    @ApiModelProperty(notes = "LastName of the Employee")
    @Column(name = "lastName")
    private String lastName;

    public long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee() {

    }

    public Employee(Long number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee: [id: "+ id + " , Number: " + number + " , FirstName: " + firstName + " , LastName: " + lastName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return number == employee.number;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (number ^ (number >>> 32));
        return result;
    }
}
