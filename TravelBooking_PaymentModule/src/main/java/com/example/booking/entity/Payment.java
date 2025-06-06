package com.example.booking.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Long userId;
    private String bookingId;
    private double amount;
    private String status;
    
    @Column(nullable = false)
    private String paymentMethod; // Should be "Credit Card" or "Debit Card"
 
    private String currency;
 
    @Transient
    private String cardNumber;  // Not stored in DB
 
    @Transient
    private String cvv;
 
    @Transient
    private String atmPin;
    
    //private String paymentMethod;
    //private String Currency;
    // Getters and Setters
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(String atmPin) {
		this.atmPin = atmPin;
	}	
 	
//	String subject = "Booking Payment Confirmation";
//	String body = "Your payment of " + payment.getAmount() + " " + payment.getCurrency() +
//	              " for Booking ID " + payment.getBookingId() + " is successful.";
//	 
//	emailService.sendEmail(customerEmail, subject, body);
//	emailService.sendEmail(agentEmail, subject, body);

}