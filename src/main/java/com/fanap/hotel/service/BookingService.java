package com.fanap.hotel.service;

import com.fanap.hotel.dto.booking.BookingInfoDTO;
import com.fanap.hotel.dto.booking.CreateBookingRequestDTO;
import com.fanap.hotel.dto.payment.CreatePaymentRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    BookingInfoDTO createBooking(Long customerId, CreateBookingRequestDTO createBookingRequestDTO, CreatePaymentRequestDTO createPaymentRequestDTO);
}
