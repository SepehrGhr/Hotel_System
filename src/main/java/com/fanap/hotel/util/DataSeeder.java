package com.fanap.hotel.util;

import com.fanap.hotel.model.*;
import com.fanap.hotel.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private final AdditionalServiceRepository additionalServiceRepository;

    public DataSeeder(CustomerRepository customerRepository, RoomRepository roomRepository, BookingRepository bookingRepository, PaymentRepository paymentRepository, AdditionalServiceRepository additionalServiceRepository) {
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
        this.additionalServiceRepository = additionalServiceRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedAdditionalServices();
    }

    private void seedAdditionalServices() {
        if (additionalServiceRepository.count() == 0) {
            AdditionalService service1 = new AdditionalService("Internet", new BigDecimal("10.00"));
            AdditionalService service2 = new AdditionalService("Parking", new BigDecimal("5.00"));
            AdditionalService service3 = new AdditionalService("Dinner", new BigDecimal("20.00"));
            additionalServiceRepository.saveAll(List.of(service1, service2, service3));
        }
    }
}
