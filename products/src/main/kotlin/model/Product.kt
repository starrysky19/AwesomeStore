package model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class Product(
    val id: Long? = null,  // Use Long for the id field
    val name: String,
    val price: Double,
    val description: String?
)
