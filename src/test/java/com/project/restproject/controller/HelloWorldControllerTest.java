package com.project.restproject.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class, secure = false)
public class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;


    /*
    Test Test helloWorldAPI Success
    @result Valid Response with Response Code 200
    */
    @Test
    public void testHelloWorld() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/helloWorld").accept(
                MediaType.APPLICATION_JSON);
        String expectedResponse = "helloWorld";
        int expectedResponseCode = 200;
        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse actualResponse = actualResult.getResponse();
        Assert.assertEquals(expectedResponseCode,         actualResponse.getStatus());
        Assert.assertEquals(expectedResponse, actualResponse.getContentAsString());
    }
}
