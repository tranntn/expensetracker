package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressMethod(){
        Order order = new Order();
        order.setStatus("IN PROGRESS");
        order.setTotalQuantity(6);
        order.setTotalPrice(new BigDecimal(1000));
        order.setOrderTrackingNumber("11K90");

        Address address = new Address();
        address.setCountry("Viet Nam");
        address.setZip("7000");
        address.setCity("Ho Chi Minh");
        address.setState("UK");
        address.setStreet("To Ky");

        order.setBillingAddress(address);
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod(){
        Address address = addressRepository.findById(1L).get();
        address.setZip("6000");

        address.getOrder().setStatus("DELIVERED");
        addressRepository.save(address);
    }

    @Test
    void fetchAddressMethod(){
        Address address = addressRepository.findById(1L).get();
    }

    @Test
    void deleteAddressMethod(){
        addressRepository.deleteById(1L);
    }
}
