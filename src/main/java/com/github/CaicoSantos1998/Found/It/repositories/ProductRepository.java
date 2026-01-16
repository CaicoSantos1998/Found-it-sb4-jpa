package com.github.CaicoSantos1998.Found.It.repositories;

import com.github.CaicoSantos1998.Found.It.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
