package com.github.CaicoSantos1998.Found.It.services;

import com.github.CaicoSantos1998.Found.It.entities.Order;
import com.github.CaicoSantos1998.Found.It.repositories.OrderRepository;
import com.github.CaicoSantos1998.Found.It.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> optional = repository.findById(id);
        return optional.get();
    }
}
