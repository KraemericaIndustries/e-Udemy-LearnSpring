package com.ki.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ki.demo.domain.Product;

@RestController
@RequestMapping("/user")  //  .../user is the root URL for this controller
public class UserController {
	
	@RequestMapping("/{userId}")  //  Will serve replies to http://localhost:8080/user/35, where 35 is a randomly selected number
	public String displayUser(@PathVariable int userId) {
		return "User Found: " + userId;
	}

	//  Will serve replies to http://localhost:8080/user/32/invoices?date=12/10/2010, where 32 is a randomly selected number, or
	//  Will serve replies to http://localhost:8080/user/99/invoices?d=12/10/2010, where 99 is a randomly selected number, or
	//  Will serve replies to http://localhost:8080/user/98/invoices, where 98 is a randomly selected number (depending on progress in the lecture)
	@RequestMapping("/{id}/invoices")  
	public String displayUserInvoices(@PathVariable("id") int userId, @RequestParam(value = "date", required = false) Date dateOrNull) {
		return "Invoice found for user: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("Shoes", "Laptop", "Button");
	}
	
	//  Will serve replies to http://localhost:8080/user/12/products_as_json, where 32 is a randomly selected number, or
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsJson() {
		return Arrays.asList(new Product(1, "Shoes", 42.99), new Product(2, "Books", 12.99), new Product(3, "Bag", 45.99));
	}
}