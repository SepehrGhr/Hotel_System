package com.fanap.hotel.mapper;

import com.fanap.hotel.dto.customer.CreateCustomerRequestDTO;
import com.fanap.hotel.dto.customer.CustomerInfoDTO;
import com.fanap.hotel.model.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerInfoDTO toDTO(Customer customer);

    Customer toEntity(CustomerInfoDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(CreateCustomerRequestDTO dto, @MappingTarget Customer customer);
}