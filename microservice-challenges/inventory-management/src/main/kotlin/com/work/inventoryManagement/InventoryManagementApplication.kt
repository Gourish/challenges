package com.work.inventoryManagement

import com.work.inventoryManagement.controller.ProductController
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.work.inventoryManagement"] )
class InventoryManagementApplication
fun main(args: Array<String>) {
	runApplication<InventoryManagementApplication>(*args)
}

