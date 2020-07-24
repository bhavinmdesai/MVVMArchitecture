package dev.bhavindesai.mvvmarch.data.remote

import retrofit2.Retrofit

interface ApiService {

    companion object Factory {
        fun create(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
    }
}

