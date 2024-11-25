package com.example.products.repository

import model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, Long> {
    // You can add custom queries if needed
}
