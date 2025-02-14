package com.fanap.hotel.service;

import com.fanap.hotel.dto.payment.CreatePaymentRequestDTO;
import com.fanap.hotel.model.Booking;
import com.fanap.hotel.model.Payment;
import com.fanap.hotel.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void processPayment(Booking booking, CreatePaymentRequestDTO paymentRequest) {
        BigDecimal totalAmount = booking.getTotalAmount();
        Payment payment = new Payment(booking, totalAmount, LocalDate.now(), paymentRequest.getPaymentMethod());
        paymentRepository.save(payment);
    }
}
