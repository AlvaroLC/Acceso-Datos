package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.product

import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.ProductModel
import com.alvarolc.aad_playground.ut03_database.ex_04.domain.ProductRepository


class ProductDataRepository(private val productLocalSource: ProductLocalSource) :
    ProductRepository {
    override fun save(productModel: ProductModel) {
        productLocalSource.save(productModel)
    }

    override fun delete(productModel: ProductModel) {
        TODO("Not yet implemented")
    }

    override fun update(productModel: ProductModel) {
        TODO("Not yet implemented")
    }

    override fun fetchAll(): List<ProductModel> {
        TODO("Not yet implemented")
    }

}