
package com.example.booking.repository;
 
import com.example.booking.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
