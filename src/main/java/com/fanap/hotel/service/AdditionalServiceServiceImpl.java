package com.fanap.hotel.service;

import com.fanap.hotel.model.AdditionalService;
import com.fanap.hotel.repository.AdditionalServiceRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
