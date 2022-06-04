package com.company.springdatademo;

import com.company.springdatademo.model.Address;
import com.company.springdatademo.model.Employee;
import com.company.springdatademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataDemoApplication  implements CommandLineRunner{


    private final EmployeeService employeeService;

    public SpringDataDemoApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Anar");
        employee.setSurname("Mikayilov");
        employee.setAge(21);
        employee.setSalary(6000);

        Address address = new Address();
        address.setStreet("Mahammad Xiyabani");

        employeeService.update(employee,address);

        employeeService.getAllEmployees()
                .forEach(System.out::println);
    }
}
