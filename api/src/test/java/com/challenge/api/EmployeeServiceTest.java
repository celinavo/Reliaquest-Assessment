package com.challenge.api;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.api.model.RQEmployee;
import com.challenge.api.service.EmployeeService;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    void contextLoads() {}

    @Test
    void testGetAllEmployees() {

        assertEquals(3, service.getAllEmployees().size());
    }

    @Test
    void testGetEmployeeByUuid() {

        UUID expectedUuid = UUID.fromString("00000000-0000-0000-0000-000000000001");
        UUID actualUuid = service.getEmployeeByUuid(expectedUuid).getUuid();

        assertEquals(expectedUuid, actualUuid);
    }

    @Test
    void testCreateEmployee() {

        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000003");

        LocalDate today = LocalDate.now();
        Instant hireDate = today.atStartOfDay().toInstant(ZoneOffset.UTC);

        RQEmployee employee = new RQEmployee(
                uuid, "Jane", "Doe", "Jane Doe", 90000, 26, "Software Engineer", "janedoe@mail.com", hireDate, null);

        assertEquals(employee, service.createEmployee(employee));
    }
}
