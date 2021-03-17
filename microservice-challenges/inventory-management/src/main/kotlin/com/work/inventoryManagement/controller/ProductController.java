package com.work.inventoryManagement.controller;

import com.work.inventoryManagement.api.ProductData;
import com.work.inventoryManagement.model.Product;
import com.work.inventoryManagement.repos.ProductRepository;
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
    ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductData productData)
    {
        try
        {
            Product _product = productRepository.save(new Product(UUID.randomUUID(),productData.getName(),productData.getCategory(),productData.getDescription(),productData.getQuantity(),productData.getPrice()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productsList")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        try
        {
            List<Product> products = new ArrayList<>();
            productRepository.findAll().forEach(products::add);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productsListById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") UUID id)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productsListByName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name)
    {
        Optional<Product> product = productRepository.findByName(name);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/productsListByCategory/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category)
    {
        try{
        List<Product> products = new ArrayList<>();
        productRepository.findByCategory(category).forEach(products::add);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
            catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("") UUID id, @RequestBody ProductData productdata)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
        {
            Product _product = product.get();
            _product.setName(productdata.getName());
            _product.setCategory(productdata.getCategory());
            _product.setDescription(productdata.getDescription());
            _product.setQuantity(productdata.getQuantity());
            _product.setPrice(productdata.getPrice());
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
        }
        else
        {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") UUID id)
    {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
