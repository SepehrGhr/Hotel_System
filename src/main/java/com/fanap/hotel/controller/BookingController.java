package com.fanap.hotel.controller;

import com.fanap.hotel.dto.BaseResponse;
import com.fanap.hotel.dto.booking.BookingInfoDTO;
import com.fanap.hotel.dto.booking.BookingWithPaymentRequestDTO;
import com.fanap.hotel.service.BookingService;
import com.fanap.hotel.util.constants.Constants;
import com.fanap.hotel.util.constants.Routes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Routes.BOOKING_ROUTE)
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(Routes.CUSTOMER_ID_PARAM_KEY)
    public ResponseEntity<BaseResponse<BookingInfoDTO>> createBooking(@PathVariable(value = Constants.ID) Long customerId,@Valid @RequestBody BookingWithPaymentRequestDTO request) {
        return ResponseEntity.status(201).body(BaseResponse.success(bookingService.createBooking(customerId, request.getCreateBookingRequestDTO(), request.getCreatePaymentRequestDTO())));
    }
}
