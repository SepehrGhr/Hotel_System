package com.fanap.hotel.service;

import com.fanap.hotel.dto.payment.CreatePaymentRequestDTO;
import com.fanap.hotel.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public void processPayment(Booking booking, CreatePaymentRequestDTO paymentRequest);
}
