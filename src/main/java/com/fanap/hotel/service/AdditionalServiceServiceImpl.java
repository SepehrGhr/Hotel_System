package com.fanap.hotel.service;

import com.fanap.hotel.model.AdditionalService;
import com.fanap.hotel.repository.AdditionalServiceRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService{

    private final AdditionalServiceRepository additionalServiceRepository;

    public AdditionalServiceServiceImpl(AdditionalServiceRepository additionalServiceRepository) {
        this.additionalServiceRepository = additionalServiceRepository;
    }

    @Override
    public Set<AdditionalService> findAllById(List<Long> additionalServiceIds) {
        return new HashSet<>(additionalServiceRepository.findAllById(additionalServiceIds));
    }
}
