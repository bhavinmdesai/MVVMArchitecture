package dev.bhavindesai.mvvmarch.data.remote

import dev.bhavindesai.mvvmarch.data.remote.models.LoginRequest
import dev.bhavindesai.mvvmarch.data.remote.models.LoginResponse
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest) : LoginResponse

    companion object Factory {
        fun create(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    }
}

