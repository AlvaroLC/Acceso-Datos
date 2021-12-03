package com.alvarolc.aad_playground.ut03_database.ex_04.domain

import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.ProductModel

interface ProductRepository {
    fun save(productModel: ProductModel)
    fun delete(productModel: ProductModel)
    fun update(productModel: ProductModel)
    fun fetchAll(): List<ProductModel>
}