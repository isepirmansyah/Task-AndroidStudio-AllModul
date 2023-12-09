package com.example.tugashadiahtask


import com.example.tugashadiahtask.Model.DataItem
import com.example.tugashadiahtask.Model.MyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("patients")
    fun getAllPatients(): Call<MyResponse>

    @GET("patients/{id}")
    fun getPatientById(@Path("id") id: Int): Call<DataItem>

    @GET("patients/search/{name}")
    fun searchPatientByName(@Path("name") name: String): Call<MyResponse>
}