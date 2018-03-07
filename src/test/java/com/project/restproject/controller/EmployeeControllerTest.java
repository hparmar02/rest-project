package com.project.restproject.controller;


import com.project.restproject.model.Employee;
import com.project.restproject.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;

    private RequestBuilder requestBuilder;
    private String expectedResponse;
    private String exampleEmployeeJSON;
    private Employee mockEmployee;

    @Before
    public void setUp(){
        expectedResponse = "{\"id\":1,\"firstName\":\"testFirstName\",\"lastName\":\"testLastName\"}";
        exampleEmployeeJSON = "{\"firstName\":\"testFirstName\",\"id\":1,\"lastName\":\"testLastName\"}";
        mockEmployee = new Employee(1L, "testFirstName", "testLastName");
    }

    @Test
    @Ignore
    public void testSaveSuccess() throws Exception{
        int expectedResponseCode = 201;
        Mockito.when(employeeService.get(Mockito.anyString())).thenReturn(Optional.empty());

        Mockito.when(employeeService.save(Mockito.any(Employee.class))).thenReturn(mockEmployee);
        requestBuilder = MockMvcRequestBuilders.post(
                "/employee/").accept(
                MediaType.APPLICATION_JSON).content(exampleEmployeeJSON).contentType(MediaType.APPLICATION_JSON);
        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse actualResponse = actualResult.getResponse();

        Assert.assertEquals(expectedResponseCode,         actualResponse.getStatus());
        JSONAssert.assertEquals(expectedResponse, actualResponse.getContentAsString(), false);
    }
//
//    @Test
//    public void testSaveEmployeeAlreadyExists() throws Exception{
//        int expectedResponseCode = 400;
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenReturn(mockEmployee);
//
//
//        requestBuilder = MockMvcRequestBuilders.post(
//                "/employee/").accept(
//                MediaType.APPLICATION_JSON).content(exampleEmployeeJSON).contentType(MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//        Assert.assertEquals(expectedResponseCode,         actualResponse.getStatus());
//    }
//
//
//    @Test
//    public void testSaveEmployeeException() throws Exception{
//        int expectedResponseCode = 500;
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenReturn(null);
//
//        Mockito.when(employeeService.save(Mockito.any(Employee.class))).thenThrow(Exception.class);;
//
//
//        requestBuilder = MockMvcRequestBuilders.post(
//                "/employee/").accept(
//                MediaType.APPLICATION_JSON).content(exampleEmployeeJSON).contentType(MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//        Assert.assertEquals(expectedResponseCode,         actualResponse.getStatus());
//    }
//
//
//    @Test
//    public void testGetEmployeeSuccess() throws Exception{
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenReturn(mockEmployee);
//
//        requestBuilder = MockMvcRequestBuilders.get(
//                "/employee/1").accept(
//                MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//        int expectedResponseCode = 200;
//
//        Assert.assertEquals(expectedResponseCode, actualResponse.getStatus());
//
//        JSONAssert.assertEquals(expectedResponse, actualResponse.getContentAsString(), false);
//    }
//
//
//    @Test
//    public void testGetEmployeeNotFound() throws Exception{
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenReturn(null);
//
//        requestBuilder = MockMvcRequestBuilders.get(
//                "/employee/1").accept(
//                MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//        int expectedResponseCode = 404;
//
//        Assert.assertEquals(expectedResponseCode, actualResponse.getStatus());
//    }
//
//    @Test
//    public void testGetEmployeethrowException() throws Exception{
//        int expectedResponseCode = 500;
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenThrow(Exception.class);
//        requestBuilder = MockMvcRequestBuilders.get(
//                "/employee/1").accept(
//                MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//
//        Assert.assertEquals(expectedResponseCode, actualResponse.getStatus());
//    }
//
//
//    @Test
//    public void testDeleteEmployeeSuccess() throws Exception{
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenReturn(mockEmployee);
//
//        requestBuilder = MockMvcRequestBuilders.delete(
//                "/employee/1").accept(
//                MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//        int expectedResponseCode = 200;
//
//        Mockito.doNothing().when(employeeService).delete(Mockito.anyLong());
//        Assert.assertEquals(expectedResponseCode, actualResponse.getStatus());
//    }
//
//    @Test
//    public void testDeleteEmployeeNotFound() throws Exception{
//        Mockito.when(employeeService.get(Mockito.anyLong())).thenReturn(null);
//
//        requestBuilder = MockMvcRequestBuilders.delete(
//                "/employee/1").accept(
//                MediaType.APPLICATION_JSON);
//        MvcResult actualResult = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse actualResponse = actualResult.getResponse();
//        int expectedResponseCode = 404;
//
//        Mockito.doNothing().when(employeeService).delete(Mockito.anyLong());
//        Assert.assertEquals(expectedResponseCode, actualResponse.getStatus());
//    }

}
