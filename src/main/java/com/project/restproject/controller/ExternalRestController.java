package com.project.restproject.controller;

import com.project.restproject.service.ExternalRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "External", value = "ExternalRestApi", description = "Rest Api to query external endpoint")
public class ExternalRestController {

    @Autowired
    private ExternalRestService externalRestService;
    private static final Logger logger = LoggerFactory.getLogger(ExternalRestController.class);

    @ApiOperation(value = "Returns Response from External Rest Endpoint")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Response from External API" ),
                    @ApiResponse(code = 204, message = "Response from External is NULL" ),
                    @ApiResponse(code = 500, message = "Exception - Internal Error" )
            }
    )
    @RequestMapping(value = "/external", method= RequestMethod.GET)
    public ResponseEntity<?> getInformation(){
        logger.info("Rest request received for external call");

        try{
            String result = externalRestService.getResponseFromExternalURL();

            if (result == null){
                logger.debug("Response for externalURL is NULL");
                return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
            }

            logger.debug("Rest response for externalURL: {}", result);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex){
            logger.error("Exception when making externalURL.", ex);
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
