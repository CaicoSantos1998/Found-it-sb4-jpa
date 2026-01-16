package com.github.CaicoSantos1998.Found.It.repositories;

import com.github.CaicoSantos1998.Found.It.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
