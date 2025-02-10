package com.challenge.api.service;

import com.challenge.api.model.RQEmployee;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private List<RQEmployee> RQEmployeeList;

    // Constructor with mock employee model
    public EmployeeService() {
        RQEmployeeList = new ArrayList<>();

        UUID uuid1 = UUID.fromString("00000000-0000-0000-0000-000000000001");
        UUID uuid2 = UUID.fromString("00000000-0000-0000-0000-000000000002");
        UUID uuid3 = UUID.fromString("00000000-0000-0000-0000-000000000003");

        LocalDate today = LocalDate.now();
        Instant hireDate = today.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant terminationDateNotTerminated = Instant.parse("2025-12-31T00:00:00Z");
        Instant terminationDateTerminated = Instant.parse("2023-12-31T00:00:00Z");

        RQEmployee RQEmployee1 = new RQEmployee(
                uuid1,
                "Celina",
                "Vo",
                "Celina Vo",
                80000,
                22,
                "Associate Software Engineer",
                "celinavo@usf.edu",
                hireDate,
                null);
        RQEmployee RQEmployee2 = new RQEmployee(
                uuid2,
                "John",
                "Doe",
                "John Doe",
                100000,
                27,
                "Senior Software Engineer",
                "johndoe@mail.com",
                hireDate,
                terminationDateNotTerminated);
        RQEmployee RQEmployee3 = new RQEmployee(
                uuid3,
                "Jane",
                "Doe",
                "Jane Doe",
                100000,
                27,
                "Senior Software Engineer",
                "janedoe@mail.com",
                hireDate,
                terminationDateTerminated);

        RQEmployeeList.add(RQEmployee1);
        RQEmployeeList.add(RQEmployee2);
        RQEmployeeList.add(RQEmployee3);
    }

    public List<RQEmployee> getAllEmployees() {
        return RQEmployeeList;
    }

    public RQEmployee getEmployeeByUuid(UUID uuid) {
        for (int i = 0; i < RQEmployeeList.size(); i++) {
            if (RQEmployeeList.get(i).getUuid().equals(uuid)) {
                return RQEmployeeList.get(i);
            }
        }
        throw new NoSuchElementException("Employee with UUID " + uuid + " not found");
    }

    public RQEmployee createEmployee(RQEmployee employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }

        RQEmployeeList.add(employee);

        return employee;
    }
}
