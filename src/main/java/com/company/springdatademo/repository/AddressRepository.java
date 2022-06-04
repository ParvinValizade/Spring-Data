package com.company.springdatademo.repository;

import com.company.springdatademo.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
