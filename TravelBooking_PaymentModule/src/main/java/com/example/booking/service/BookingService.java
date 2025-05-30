package com.example.booking.service;

import com.example.booking.entity.Booking;
import com.example.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepo;

    public Booking createBooking(Booking booking) {
        booking.setStatus("CONFIRMED");
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}