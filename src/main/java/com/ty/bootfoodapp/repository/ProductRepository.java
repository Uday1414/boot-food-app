package com.ty.bootfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bootfoodapp.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
