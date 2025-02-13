package com.fanap.hotel.dto.customer;

import com.fanap.hotel.model.Customer;

public class CreateCustomerRequestDTO {

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    public CreateCustomerRequestDTO(){

    }

    public Customer toEntity(){
        return new Customer(this.name, this.email, this.phoneNumber, this.address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
