package com.carlosjr.springjasper.bootstrap;

import com.carlosjr.springjasper.employee.Employee;
import com.carlosjr.springjasper.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class MockData implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {

        if (employeeRepository.count() == 0){
            loadEmployees();
        }
    }

    private void loadEmployees() {

        Employee employee1 = Employee
                .builder()
                .name("Testson silva")
                .age(25)
                .active(true)
                .address("Rua europa 2")
                .salary(2300.00)
                .build();
        Employee employee2 = Employee
                .builder()
                .name("Ricardo silva")
                .age(18)
                .active(true)
                .address("Rua america 4")
                .salary(1500.00)
                .build();
        Employee employee3 = Employee
                .builder()
                .name("Adriano silva")
                .age(28)
                .active(true)
                .address("Rua europa 7")
                .salary(1200.00)
                .build();
        Employee employee4 = Employee
                .builder()
                .name("Robson silva")
                .age(32)
                .active(true)
                .address("Rua europa 3")
                .salary(1800.00)
                .build();
        Employee employee5 = Employee
                .builder()
                .name("Robertson silva")
                .age(23)
                .active(false)
                .address("Rua oceania 2")
                .salary(1200.00)
                .build();

        employeeRepository.saveAll(Arrays.asList(employee1, employee2,
                employee3, employee4, employee5));

    }
}
