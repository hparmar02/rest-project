package com.project.restproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "HelloWorld", value = "HelloWorldRestApi", description = "Rest Api for HelloWorld")
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @ApiOperation(value = "Returns HelloWorld")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful Response" )
            }
    )
    @RequestMapping(value = "/helloWorld", method= RequestMethod.GET)
    public ResponseEntity<String> getHelloWorld(){
        logger.info("Rest request received for helloWorld");
        String returnString = "helloWorld";
        logger.debug("Response for getHelloWorld is: {}", returnString);
        return new ResponseEntity<>(returnString, HttpStatus.OK);
    }
}
