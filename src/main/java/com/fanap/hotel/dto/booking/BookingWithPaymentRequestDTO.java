package com.fanap.hotel.dto.booking;

import com.fanap.hotel.dto.payment.CreatePaymentRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingWithPaymentRequestDTO {

    @NotNull(message = "required.BOOKING_REQUEST")
    private CreateBookingRequestDTO createBookingRequestDTO;

    @NotNull(message = "required.PAYMENT_REQUEST")
    private CreatePaymentRequestDTO createPaymentRequestDTO;

    public BookingWithPaymentRequestDTO(){

    }

    public BookingWithPaymentRequestDTO(CreateBookingRequestDTO createBookingRequestDTO, CreatePaymentRequestDTO createPaymentRequestDTO) {
        this.createBookingRequestDTO = createBookingRequestDTO;
        this.createPaymentRequestDTO = createPaymentRequestDTO;
    }

    public CreateBookingRequestDTO getCreateBookingRequestDTO() {
        return createBookingRequestDTO;
    }

    public CreatePaymentRequestDTO getCreatePaymentRequestDTO() {
        return createPaymentRequestDTO;
    }

    public void setCreateBookingRequestDTO(CreateBookingRequestDTO createBookingRequestDTO) {
        this.createBookingRequestDTO = createBookingRequestDTO;
    }

    public void setCreatePaymentRequestDTO(CreatePaymentRequestDTO createPaymentRequestDTO) {
        this.createPaymentRequestDTO = createPaymentRequestDTO;
    }
}
