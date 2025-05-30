package com.example.booking.service;

import com.example.booking.entity.Payment;
import com.example.booking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepo;
 
    @Autowired
    private NotificationService notificationService;
 
    public Payment processPayment(Payment payment) {
        if (!payment.getPaymentMethod().equalsIgnoreCase("Credit Card") &&
            !payment.getPaymentMethod().equalsIgnoreCase("Debit Card")) {
            throw new IllegalArgumentException("Only Credit Card or Debit Card are accepted.");
        }
 
        if (payment.getCardNumber() == null || !payment.getCardNumber().matches("\\d{16}")) {
            throw new IllegalArgumentException("Invalid card number. Must be 16 digits.");
        }
 
        if (payment.getCvv() == null || !payment.getCvv().matches("\\d{3}")) {
            throw new IllegalArgumentException("Invalid CVV. Must be 3 digits.");
        }
 
        if (payment.getAtmPin() == null || !payment.getAtmPin().matches("\\d{4}")) {
            throw new IllegalArgumentException("Invalid ATM PIN. Must be 4 digits.");
        }
 
        payment.setStatus("PAID");
        Payment saved = paymentRepo.save(payment);
 
        // Notify customer and agent with booking info (mocked)
        String customerEmail = "customer@example.com"; // Fetch dynamically from DB if needed
        String agentEmail = "agent@example.com";       // Fetch dynamically if needed
        String message = "Payment of " + payment.getAmount() + " " + payment.getCurrency() +
                         " for booking ID " + payment.getBookingId() + " is successful.";
 
        notificationService.notifyCustomer(customerEmail, message);
        notificationService.notifyTravelAgent(agentEmail, message);
 
        return saved;
    }
 
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }
 
    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }
}
