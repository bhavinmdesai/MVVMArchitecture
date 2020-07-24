package dev.bhavindesai.mvvmarch.di.providers

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

object RetrofitProvider {

    fun provide(converterFactory: Converter.Factory, client: OkHttpClient): Retrofit = Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .client(client)
                .baseUrl("https://reqres.in/api/")
                .build()
}