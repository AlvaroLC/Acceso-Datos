package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.product

import android.content.Context
import com.alvarolc.aad_playground.ut03_database.ex_04.app.Ut03Ex04DataBase
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.ProductModel
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db.ProductEntity

class ProductLocalSource(applicationContext: Context) {

    private val db = Ut03Ex04DataBase.getInstance(applicationContext)

    init {
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    fun save(productModel: ProductModel) {
        db.productDao().insert(ProductEntity.toEntity(productModel,))
    }

    fun findAll(): List<ProductModel> {
        val products = db.productDao().findAll()
        return products.map { productEntity -> productEntity.toModel()}
    }

    fun delete(productModel: ProductModel){
        db.productDao().delete(ProductEntity.toEntity(productModel))
    }

    fun update(productModel: ProductModel){
        db.productDao().update(ProductEntity.toEntity(productModel))
    }

}