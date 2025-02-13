package com.fanap.hotel.service;

import com.fanap.hotel.dto.customer.CreateCustomerRequestDTO;
import com.fanap.hotel.dto.customer.CustomerInfoDTO;
import com.fanap.hotel.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerInfoDTO getCustomerDTO(Customer customer);

    Customer createCustomerFromDTO(CustomerInfoDTO dto);

    List<CustomerInfoDTO> getAllCustomersInfo();

    CustomerInfoDTO getCustomerInfo(Long customerId);

    CustomerInfoDTO createCustomer(CreateCustomerRequestDTO createCustomerRequestDTO);

    CustomerInfoDTO updateCustomer(Long customerId, CreateCustomerRequestDTO createCustomerRequestDTO);

    void deleteCustomer(Long customerId);
}
