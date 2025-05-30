package com.example.booking.entity;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.IntStream;

import jakarta.persistence.*;

@Entity
public class Booking {

	private static final AtomicInteger bookingCounter = new AtomicInteger(1000);
    private static final AtomicInteger userCounter = new AtomicInteger(1000);
    
    @Id
    private Long bookingId;
    private String userId;
    private String packageId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private Long paymentId;

    @PrePersist
    public void generateIds() {
        if (this.bookingId == null) {
            this.bookingId =(long)bookingCounter.getAndIncrement();
        }
        if (this.userId == null) {
            this.userId = "User" + userCounter.getAndIncrement();
        }
    }
    
    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


}
