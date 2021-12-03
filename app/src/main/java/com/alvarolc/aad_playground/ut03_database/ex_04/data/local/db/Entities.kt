package com.alvarolc.aad_playground.ut03_database.ex_04.data.local.db

import androidx.room.*
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.CustomerModel
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.InvoiceLinesModel
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.InvoiceModel
import com.alvarolc.aad_playground.ut03_database.ex_04.data.local.ProductModel
import java.util.*

@Entity(tableName = "customer")
data class CustomerEntity(
    @PrimaryKey @ColumnInfo(name = "id") val customerId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String,
) {
    fun toModel() = CustomerModel(
        customerId,
        name,
        surname
    )

    companion object {
        fun toEntity(customerModel: CustomerModel) = CustomerEntity(
            customerModel.id,
            customerModel.name,
            customerModel.surname
        )
    }
}

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = "id") val productId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "invoice_id") val invoiceId: Int
) {
    fun toModel() = ProductModel(
        productId,
        name,
        model,
        price
    )

    companion object {
        fun toEntity(productModel: ProductModel, invoiceId: Int) = ProductEntity(
            productModel.id,
            productModel.name,
            productModel.model,
            productModel.price,
            invoiceId
        )
    }
}

@Entity(tableName = "invoice_lines")
data class InvoiceLinesEntity(
    @PrimaryKey @ColumnInfo(name = "id") val invoiceLinesId: Int,
    @ColumnInfo(name = "invoice_id") val invoiceId: Int
) {
    fun toModel(productEntity: ProductEntity) = InvoiceLinesModel(
        invoiceLinesId,
        productEntity.toModel()
    )

    companion object {
        fun toEntity(invoiceLinesModel: InvoiceLinesModel, invoiceId: Int) = InvoiceLinesEntity(
            invoiceLinesModel.id,
            invoiceId
        )
    }
}

/**
 * Una linea de factura solo pertenece a un producto
 *
 * Relación 1:1 donde InvoiceLinesEntity cede su clave primaria a Product.
 */
data class InvoiceLinesAndProduct(
    @Embedded val invoiceLinesEntity: InvoiceLinesEntity, //Entidad Principal
    @Relation(
        parentColumn = "id", //clave primaria de la entidad InvoiceLines.
        entityColumn = "invoice_id" //clave foránea de la entidad Product.
    ) val productEntity: ProductEntity, //Entidad que recibe la clave de otra entidad
)


@Entity(tableName = "invoice")
data class InvoiceEntity(
    @PrimaryKey @ColumnInfo(name = "id") val invoiceId: Int,
    @ColumnInfo(name = "date") val date: Date
) {
    fun toModel(
        customerEntity: CustomerEntity,
        productEntity: ProductEntity,
        invoiceLinesEntity: List<InvoiceLinesEntity>
    ) =
        InvoiceModel(
            invoiceId,
            date,
            customerEntity.toModel(),
            invoiceLinesEntity.map { it.toModel(productEntity) }.toMutableList()
    )

    companion object {
        fun toEntity(invoiceModel: InvoiceModel) = InvoiceEntity(
            invoiceModel.id,
            invoiceModel.date
        )
    }

}

/**
 * Una factura puede tener de 1 a N líneas de facturas
 *
 * Relación 1:N donde Invoice cede su clave primaria a InvoiceLines.
 */

data class InvoiceAndInvoiceLines(
    @Embedded val invoiceEntity: InvoiceEntity, //Entidad Principal

    @Relation(
        parentColumn = "id", //clave primaria de la entidad Invoice.
        entityColumn = "invoice_id" //clave foránea de la entidad InvoiceLines.
    ) val invoiceLinesEntity: InvoiceLinesEntity, //Entidad que recibe la clave de otra entidad

)

