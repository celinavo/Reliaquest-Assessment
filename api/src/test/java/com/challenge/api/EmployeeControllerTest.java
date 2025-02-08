package com.challenge.api;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.api.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController controller;

    @Test
    void contextLoads() {}
}
