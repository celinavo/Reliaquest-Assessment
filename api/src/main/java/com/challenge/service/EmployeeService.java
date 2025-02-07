package com.challenge.service;

import com.challenge.api.model.RQEmployee;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private List<RQEmployee> RQEmployeeList;

    // Constructor
    public EmployeeService() {

        RQEmployeeList = new ArrayList<>();
        RQEmployee RQEmployee1 = new RQEmployee(null, null, null, null, null, null, null, null, null, null);
        RQEmployee RQEmployee2 = new RQEmployee(null, null, null, null, null, null, null, null, null, null);

        RQEmployeeList.add(RQEmployee1);
        RQEmployeeList.add(RQEmployee2);
    }

    public List<RQEmployee> getALLEmployees() {
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
        UUID uuid;
        String firstName;
        String lastName;
        String fullName;
        Integer salary;
        Integer age;
        String jobTitle;
        String email;
        Instant contractHireDate;
        Instant contractTerminationDate;

        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }

        RQEmployeeList.add(employee);

        return employee;
    }
}
