package com.alvarolc.aad_playground.ut03_database.ex05.app.api


import com.alvarolc.aad_playground.ut03_database.ex05.data.remote.AlertApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * EndPoints de los servicios que se van a usar.
 * Es requisito de Retrofit crear esta interfaz.
 */
interface ApiEndPoint {
    @GET("alerts")
    suspend fun getAlerts(): Response<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    suspend fun getAlert(@Path("alert_id") alertId: String): Response<ApiResponse<AlertApiModel>>
}