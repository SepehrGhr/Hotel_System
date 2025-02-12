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

    public DataSeeder(CustomerRepository customerRepository, RoomRepository roomRepository,
                      BookingRepository bookingRepository, PaymentRepository paymentRepository) {
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedCustomers();
        seedRooms();
        seedBookingsAndPayments();
    }

    private void seedCustomers() {
        if (customerRepository.count() == 0) {
            Customer customer1 = new Customer("John Doe", "johndoe@example.com", "+123456789", "123 Street, NY");
            Customer customer2 = new Customer("Jane Smith", "janesmith@example.com", "+987654321", "456 Avenue, LA");

            customerRepository.saveAll(List.of(customer1, customer2));
            System.out.println("✅ Customers seeded.");
        }
    }

    private void seedRooms() {
        if (roomRepository.count() == 0) {
            Room room1 = new Room(RoomType.DELUXE, new BigDecimal("50.00"), Status.AVAILABLE);
            Room room2 = new Room(RoomType.STANDARD, new BigDecimal("100.00"), Status.AVAILABLE);
            Room room3 = new Room(RoomType.SWEET, new BigDecimal("200.00"), Status.AVAILABLE);

            roomRepository.saveAll(List.of(room1, room2, room3));
            System.out.println("✅ Rooms seeded.");
        }
    }

    private void seedBookingsAndPayments() {
        if (bookingRepository.count() == 0) {
            Customer customer = customerRepository.findByEmail("johndoe@example.com").orElseThrow();
            Room room = roomRepository.findById(1L).orElseThrow(); // Assuming room exists

            Booking booking = new Booking(customer, room, LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));
            bookingRepository.save(booking);

            Payment payment = new Payment(booking, room.getPrice().doubleValue(), LocalDate.now(), PaymentMethod.CREDIT_CARD);
            paymentRepository.save(payment);

            System.out.println("✅ Bookings and payments seeded.");
        }
    }
}
