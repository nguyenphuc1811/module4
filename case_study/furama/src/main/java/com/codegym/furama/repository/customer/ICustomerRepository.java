package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type_id = ct.id where c.name like %:name% and ct.name like %:nameType% and c.email like %:email%" , nativeQuery = true)
    Page<Customer> searchCustomer(@Param("name") String name, @Param("nameType") String nameType, @Param("email") String email, Pageable pageable);
}
