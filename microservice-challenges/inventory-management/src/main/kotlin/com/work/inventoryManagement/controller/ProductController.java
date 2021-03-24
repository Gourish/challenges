package com.work.inventoryManagement.controller;

import com.work.inventoryManagement.api.ProductData;
import com.work.inventoryManagement.model.Product;
import com.work.inventoryManagement.repos.ProductRepository;
import com.work.inventoryManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductData productData)
    {
         return productService.addProduct(productData);
    }

    @GetMapping("/productsList")
    public ResponseEntity<List<Product>> getAllProducts()
    {
         return productService.getAllProducts();
    }

    @GetMapping("/productsListById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") UUID id)
    {
        return productService.getProductById(id);
    }

    @GetMapping("/productsListByName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name)
    {
       return productService.getProductByName(name);
    }
    @GetMapping("/productsListByCategory/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category)
    {
         return productService.getProductByCategory(category);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("") UUID id, @RequestBody ProductData productdata)
    {
        return productService.updateProduct(id,productdata);
    }
    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") UUID id)
    {
         return productService.deleteProduct(id);
    }

}
