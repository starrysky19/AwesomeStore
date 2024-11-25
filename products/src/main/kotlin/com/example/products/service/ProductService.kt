package com.example.products.service

import com.example.products.repository.ProductRepository
import model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    // Method to get all products from the repository
    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    // Method to add a new product to the repository
    fun addProduct(product: Product): Product {
        return productRepository.save(product)
    }

    // Method to get a product by its ID (Long)
    fun getProductById(id: Long): Product? {
        return productRepository.findById(id).orElse(null)
    }

    // Method to update an existing product
    fun updateProduct(id: Long, updatedProduct: Product): Product? {
        return if (productRepository.existsById(id)) {
            updatedProduct.copy(id = id)
            productRepository.save(updatedProduct)
        } else {
            null
        }
    }

    // Method to delete a product by its ID
    fun deleteProduct(id: Long): Boolean {
        return if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
