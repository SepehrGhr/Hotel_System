package com.fanap.hotel.service;

import com.fanap.hotel.dto.customer.CreateCustomerRequestDTO;
import com.fanap.hotel.dto.customer.CustomerInfoDTO;
import com.fanap.hotel.exception.CustomerNotFoundException;
import com.fanap.hotel.mapper.CustomerMapper;
import com.fanap.hotel.model.Customer;
import com.fanap.hotel.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerInfoDTO getCustomerDTO(Customer customer) {
        return CustomerMapper.INSTANCE.toDTO(customer);
    }

    @Override
    public Customer createCustomerFromDTO(CustomerInfoDTO dto) {
        return CustomerMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public List<CustomerInfoDTO> getAllCustomersInfo() {
        return customerRepository.findAll().stream().map(this::getCustomerDTO).toList();
    }

    @Override
    public CustomerInfoDTO getCustomerInfo(Long customerId) {
        Customer customer = getById(customerId);
        return getCustomerDTO(customer);
    }

    @Override
    public CustomerInfoDTO createCustomer(CreateCustomerRequestDTO createCustomerRequestDTO) {
        Customer customer = createCustomerRequestDTO.toEntity();
        customer = customerRepository.save(customer);
        return getCustomerDTO(customer);
    }

    @Override
    public CustomerInfoDTO updateCustomer(Long customerId, CreateCustomerRequestDTO createCustomerRequestDTO) {
        Customer customer = getById(customerId);
        CustomerMapper.INSTANCE.updateCustomerFromDto(createCustomerRequestDTO, customer);
        customerRepository.save(customer);
        return getCustomerDTO(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    private Customer getById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
}
