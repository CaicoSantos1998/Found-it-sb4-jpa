package com.github.CaicoSantos1998.Found.It.repositories;

import com.github.CaicoSantos1998.Found.It.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
