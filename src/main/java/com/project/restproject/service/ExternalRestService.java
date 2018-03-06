package com.project.restproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>Service to make call to External API</h1>
 * The ExternalRestService implements a method that
 * simply makes an Rest call to the external url
 * and returns a response.
 * <p>*
 * @author  Hiren Parmar
 * @version 1.0
 * @since   2018-03-04
 */
@Service
public class ExternalRestService {

    //external URL from application.properties
    @Value( "${external.url}" )
    private String externalURL;

    private static final Logger logger = LoggerFactory.getLogger(ExternalRestService.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * This method makes a rest call to external URL
     * @return String Response from the externalURL
     */
    public String getResponseFromExternalURL() throws Exception {
        logger.info("Making rest call to external URL: {}", externalURL);
        String response = restTemplate.getForObject(externalURL, String.class);
        logger.debug("Rest call - externalURL: {} - Response: {}", externalURL, response);
        return response;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
