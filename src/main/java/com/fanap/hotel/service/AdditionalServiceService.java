package com.fanap.hotel.service;

import com.fanap.hotel.model.AdditionalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AdditionalServiceService {
    Set<AdditionalService> findAllById(List<Long> additionalServiceIds);
}
