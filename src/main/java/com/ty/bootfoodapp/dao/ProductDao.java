package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Product;
import com.ty.bootfoodapp.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById( int id){
		Optional<Product> optional=productRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Product updateProductById( Product product ,  int id){
		Optional<Product> optional=productRepository.findById(id);
		if(optional.isPresent()) {
			return productRepository.save(product);
		}else {
			return null;
		}
	}
	
	public String deleteProductById( int id){
		Optional<Product> optional=productRepository.findById(id);
		if(optional.isPresent()) {
			productRepository.delete(optional.get());
			return "Deleted";
		}else {
			return "No Product to delete";
		}
	}
}
