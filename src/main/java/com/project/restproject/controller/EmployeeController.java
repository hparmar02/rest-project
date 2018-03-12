package com.project.restproject.controller;

import com.project.restproject.model.Employee;
import com.project.restproject.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(tags = "Employee", value = "EmployeeRestApi", description = "Rest Api for Employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Returns Employee for a number")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Employee Object" ),
                    @ApiResponse(code = 404, message = "Employee not found" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/employee/{number}", method= RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("number") Long number){
        logger.info("GET Request received for Employee number: {}", number);
        try{
            Optional<Employee> employee = employeeService.get(number);
            if (employee.isPresent()){
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
            logger.error("GET Employee with number: {} NOT found.", number);
            return new ResponseEntity<>("Employee not found with number: " + number, HttpStatus.NOT_FOUND);
        } catch (Exception ex){
            logger.error("Exception - Get Request for Employee number: {}.",number, ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Deletes Employee for number")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successfully deleted" ),
                    @ApiResponse(code = 404, message = "Get Employee not found, Delete not completed" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/employee/{number}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("number") Long number){
        logger.info("DELETE Request received for Employee number: {}", number);
        try{
            Optional<Employee> employee = employeeService.get(number);
            if (employee.isPresent()){

                employeeService.delete(employee.get().getId());
                logger.debug("Employee with number: {} successfully DELETE", number);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            logger.error("GET Employee with number: {} NOT found. DELETE not completed", number);
            return new ResponseEntity<>("Delete NOT done. " +
                    "Employee NOT found with number: " + number, HttpStatus.NOT_FOUND);
        } catch (Exception ex){
            logger.error("Exception - DELETE Request for Employee number: {}.",number, ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Creates / Saves Employee")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Successfully saved / created" ),
                    @ApiResponse(code = 404, message = "Get Employee not found, Delete not completed" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/employee/", method= RequestMethod.POST)
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){

        logger.info("Save employee : {}", employee);
        try{
            Optional<Employee> existingEmployee = employeeService.get(employee.getNumber());
            if (existingEmployee.isPresent()){
                logger.error("Employee exists with - Employee: {} - Save NOT completed.", existingEmployee);
                return new ResponseEntity<>("Employee exists with number " + employee.getNumber(), HttpStatus.BAD_REQUEST);
            }
            Employee savedEmployee = employeeService.save(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);


        } catch (Exception ex){
            logger.error("Exception - Save Request for Employee: {}.",employee, ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
