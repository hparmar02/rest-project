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

@RestController
@Api(tags = "Employee", value = "EmployeeRestApi", description = "Rest Api for Employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Returns Employee for an id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Employee Object" ),
                    @ApiResponse(code = 404, message = "Employee not found with Id" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/employee/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id){
        logger.info("GET Request received for Employee Id: {}", id);
        try{
            Employee employee = employeeService.get(id);
            if (employee == null){
                logger.error("GET Employee with id: {} NOT found.", id);
                return new ResponseEntity<>("Employee not found with Id: " + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex){
            logger.error("Exception - Get Request for Employee id: {}.",id, ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Deletes Employee for an id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successfully deleted" ),
                    @ApiResponse(code = 404, message = "Get Employee with Id not found, Delete not completed" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/employee/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        logger.info("DELETE Request received for Employee Id: {}", id);
        try{
            Employee employee = employeeService.get(id);
            if (employee == null){
                logger.error("GET Employee with id: {} NOT found. DELETE not completed", id);
                return new ResponseEntity<>("Delete NOT done. " +
                        "Employee NOT found with Id: " + id, HttpStatus.NOT_FOUND);
            }
            employeeService.delete(id);
            logger.debug("Employee with ID: {} successfully DELETE", id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            logger.error("Exception - DELETE Request for Employee id: {}.",id, ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Creates / Saves Employee with an id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Successfully saved / created" ),
                    @ApiResponse(code = 404, message = "Get Employee with Id not found, Delete not completed" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/employee/", method= RequestMethod.POST)
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){

        logger.info("Save employee : {}", employee);
        try{
            Employee existingEmployee = employeeService.get(employee.getId());
            if (existingEmployee == null){
                Employee savedEmployee = employeeService.save(employee);
                return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
            }

            logger.error("Employee exists with ID: {} - Employee: {} - Save NOT completed.", existingEmployee.getId(), existingEmployee);
            return new ResponseEntity<>("Employee exists with ID " + employee.getId(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex){
            logger.error("Exception - Save Request for Employee: {}.",employee, ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
