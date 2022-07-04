package com.example.darkgreen.model

import java.io.Serializable

data class ProductCategory(
    val id: String,
    val title: String,
    val products: List<Product> = emptyList()) : Serializable
