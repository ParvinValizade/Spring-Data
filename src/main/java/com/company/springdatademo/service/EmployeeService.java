package com.company.springdatademo.service;

import com.company.springdatademo.model.Address;
import com.company.springdatademo.model.Employee;
import com.company.springdatademo.repository.AddressRepository;
import com.company.springdatademo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AddressRepository addressRepository;

    public Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeesByNameAndSurname(String name,String surname){
        return employeeRepository.findByNameAndSurname(name,surname);
    }

    public Employee getEmployeeById(int id){
        return  employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found with given id:"+id));
    }

    public  void insert(Employee employee){
        employeeRepository.save(employee);
    }

    @Transactional
    public  void update(Employee employee, Address address){

         addressRepository.save(address);

        if (employee.getId()<=0){
            throw new IllegalArgumentException("Id can not be empty");
        }
        employeeRepository.save(employee);
    }

    public  void delete(int id ){
        employeeRepository.deleteById(id);
    }
}
