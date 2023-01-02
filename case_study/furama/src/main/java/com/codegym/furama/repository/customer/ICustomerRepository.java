package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from `customer` where name like %:name% and customer_type_id = :customerType and email like %:email%", nativeQuery = true)
    Page<Customer> searchCustomer(@Param("name") String name, @Param("customerType") int customerType, @Param("email") String email, Pageable pageable);

    @Query(value = "select * from `customer` where name like %:name% and email like %:email%", nativeQuery = true)
    Page<Customer> searchCustomerAllType(@Param("name") String name, @Param("email") String email, Pageable pageable);
}
