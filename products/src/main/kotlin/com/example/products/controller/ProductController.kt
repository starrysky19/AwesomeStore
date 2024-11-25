package com.example.products.controller

import com.example.products.service.ProductService
import model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    // GET endpoint to retrieve all products
    @GetMapping
    fun getAllProducts(): List<Product> {
        return productService.getAllProducts()
    }

    // POST endpoint to add a new product
    @PostMapping
    fun addProduct(@RequestBody product: Product): Product {
        return productService.addProduct(product)
    }

    // GET endpoint to retrieve a product by ID
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): Product? {
        return productService.getProductById(id)
    }

    // PUT endpoint to update an existing product
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody updatedProduct: Product): Product? {
        return productService.updateProduct(id, updatedProduct)
    }

    // DELETE endpoint to delete a product by ID
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): Boolean {
        return productService.deleteProduct(id)
    }
}
