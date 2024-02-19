package com.ayoungs.cst323app2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayoungs.cst323app2.models.Product;
import com.ayoungs.cst323app2.repo.ProductRepo;

@RestController
public class PorductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping(value = "/product")
	private List<Product> getProduct() {
		return productRepo.findAll();
	}
	
	@PostMapping(value = "/product/save")
	public String saveProduct(@RequestBody Product product) 
	{
		productRepo.save(product);
		return "Saved..";
	}
	
	@PutMapping(value = "product/{id}")
	public String updateProduct(@PathVariable long id, @RequestBody Product product) {
		Product updateProduct = productRepo.findById(id).get();
		updateProduct.setName(product.getName());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setImage(product.getImage());
		productRepo.save(updateProduct);
		return "Updated...";
	}
	
	@DeleteMapping(value ="/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		Product deleteProduct = productRepo.findById(id).get();
		productRepo.delete(deleteProduct);
		return "Deleted product with id: " +id;
		
	}

}
