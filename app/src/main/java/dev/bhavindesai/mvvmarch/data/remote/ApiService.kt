package dev.bhavindesai.mvvmarch.data.remote

import dev.bhavindesai.mvvmarch.data.remote.models.BaseResponse
import dev.bhavindesai.mvvmarch.data.remote.models.LoginRequest
import dev.bhavindesai.mvvmarch.data.remote.models.LoginResponse
import dev.bhavindesai.mvvmarch.data.remote.models.User
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest) : LoginResponse

    @GET("users?page=1")
    suspend fun getUsers(@Query("page") page: Int = 1, @Query("per_page") per_page: Int = 10) : BaseResponse<User>

    companion object Factory {
        fun create(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    }
}

