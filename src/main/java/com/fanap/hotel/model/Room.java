package com.fanap.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Room type is required")
    @Column(nullable = false)
    private RoomType type;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Room status is required")
    @Column(nullable = false)
    private Status status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    public Room() {}

    public Room(RoomType type, BigDecimal price, Status status) {
        this.type = type;
        this.price = price;
        this.status = status;
        this.bookings = new ArrayList<>();
    }

    public boolean isAvailable(LocalDate startDate, LocalDate endDate) {
        return bookings.stream().noneMatch(booking ->
                (startDate.isBefore(booking.getCheckOutDate()) && endDate.isAfter(booking.getCheckInDate()))
        );
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
