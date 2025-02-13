package com.fanap.hotel.controller;

import com.fanap.hotel.dto.BaseResponse;
import com.fanap.hotel.dto.customer.CreateCustomerRequestDTO;
import com.fanap.hotel.dto.customer.CustomerInfoDTO;
import com.fanap.hotel.service.CustomerService;
import com.fanap.hotel.util.constants.Constants;
import com.fanap.hotel.util.constants.ResponseCodePool;
import com.fanap.hotel.util.constants.Routes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(Routes.CUSTOMER_ROUTES)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(Routes.CUSTOMER_ID_PARAM_KEY)
    public ResponseEntity<BaseResponse<CustomerInfoDTO>> getCustomer(@PathVariable(value = Constants.ID) Long customerId) {
        return ResponseEntity.ok(BaseResponse.success(customerService.getCustomerInfo(customerId)));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<CustomerInfoDTO>>> getAllCustomers() {
        return ResponseEntity.ok(BaseResponse.success(customerService.getAllCustomersInfo()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<CustomerInfoDTO>> createCustomer(@Valid @RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {
        return ResponseEntity.status(201).body(BaseResponse.success(customerService.createCustomer(createCustomerRequestDTO)));
    }

    @PutMapping(Routes.CUSTOMER_ID_PARAM_KEY)
    public ResponseEntity<BaseResponse<CustomerInfoDTO>> updateCustomer(@PathVariable(value = Constants.ID) Long customerId, @RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {
        return ResponseEntity.ok(BaseResponse.success(customerService.updateCustomer(customerId, createCustomerRequestDTO)));
    }

    @DeleteMapping(Routes.CUSTOMER_ID_PARAM_KEY)
    public ResponseEntity<BaseResponse<String>> deleteCustomer(@PathVariable(value = Constants.ID) Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }


}
