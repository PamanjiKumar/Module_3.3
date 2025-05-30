package com.example.booking.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
 
@Service
public class NotificationService {
 
    public void notifyCustomer(String email, String message) {
        // Simulate sending an email
        System.out.println("Email sent to customer (" + email + "): " + message);
    }
 
    public void notifyTravelAgent(String agentEmail, String message) {
        // Simulate sending an email
        System.out.println("Email sent to travel agent (" + agentEmail + "): " + message);
    }
}
