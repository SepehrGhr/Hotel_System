package com.fanap.hotel.service;

import com.fanap.hotel.dto.booking.BookingInfoDTO;
import com.fanap.hotel.dto.booking.CreateBookingRequestDTO;
import com.fanap.hotel.dto.payment.CreatePaymentRequestDTO;
import com.fanap.hotel.exception.RoomNotAvailableException;
import com.fanap.hotel.model.AdditionalService;
import com.fanap.hotel.model.Booking;
import com.fanap.hotel.model.Customer;
import com.fanap.hotel.model.Room;
import com.fanap.hotel.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final RoomService roomService;

    private final PaymentService paymentService;

    private final AdditionalServiceService additionalServiceService;

    public BookingServiceImpl(BookingRepository bookingRepository, CustomerService customerService, RoomService roomService, PaymentService paymentService, AdditionalServiceService additionalServiceService) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.roomService = roomService;
        this.paymentService = paymentService;
        this.additionalServiceService = additionalServiceService;
    }

    @Override
    @Transactional
    public BookingInfoDTO createBooking(Long customerId, CreateBookingRequestDTO createBookingRequestDTO, CreatePaymentRequestDTO createPaymentRequestDTO) {
        Customer customer = customerService.getById(customerId);
        Room room = roomService.getById(createBookingRequestDTO.getRoomId());

        // check if selected room is available in selected time span
        if (!room.isAvailable(createBookingRequestDTO.getCheckInDate(), createBookingRequestDTO.getCheckOutDate())) {
            throw new RoomNotAvailableException(createBookingRequestDTO.getRoomId());
        }
        Booking booking = new Booking(customer, room, LocalDate.now(),
                createBookingRequestDTO.getCheckInDate(),
                createBookingRequestDTO.getCheckOutDate());

        Set<AdditionalService> additionalServiceSet = new HashSet<>();
        if (createBookingRequestDTO.getAdditionalServiceIds() != null && !createBookingRequestDTO.getAdditionalServiceIds().isEmpty()) {
            Set<AdditionalService> services = additionalServiceService.findAllById(createBookingRequestDTO.getAdditionalServiceIds());
            booking.setAdditionalServices(services);
        }

        booking = bookingRepository.save(booking);

        paymentService.processPayment(booking, createPaymentRequestDTO);

        return new BookingInfoDTO(room.getId(), createBookingRequestDTO.getCheckInDate(),
                createBookingRequestDTO.getCheckOutDate(), booking.getBookingDate(),
                createBookingRequestDTO.getAdditionalServiceIds());
    }
}
