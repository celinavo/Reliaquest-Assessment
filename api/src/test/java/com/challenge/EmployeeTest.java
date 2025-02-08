package com.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import com.challenge.api.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller.getAllEmployees()).isNotNull();
    }
}
