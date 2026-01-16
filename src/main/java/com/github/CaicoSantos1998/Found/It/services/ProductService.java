package com.github.CaicoSantos1998.Found.It.services;

import com.github.CaicoSantos1998.Found.It.entities.Product;
import com.github.CaicoSantos1998.Found.It.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optional = repository.findById(id);
        return optional.get();
    }
}
