package com.example.lab4.Data

import retrofit2.http.GET

interface RandomUserService {
    @GET("api/?results=20")
    suspend fun getUsers(): RandomUserResponse
}
