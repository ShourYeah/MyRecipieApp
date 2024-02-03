package com.example.myrecipieapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build()

val recipieService = retrofit.create(ApiService::class.java)


interface ApiService {
    @GET("categories.php")  //Allow HTTP request
    suspend fun getCategories():CategoriesResponse //suspend keyword is designed to handle asynchronous tasks, like waiting for data to be fetched without blocking the entire program/prevent UI freezing while loading maintain concurrency.


}