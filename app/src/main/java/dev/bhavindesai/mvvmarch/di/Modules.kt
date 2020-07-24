package dev.bhavindesai.mvvmarch.di

import dev.bhavindesai.mvvmarch.data.remote.ApiService
import dev.bhavindesai.mvvmarch.di.providers.HttpLoggingInterceptorProvider
import dev.bhavindesai.mvvmarch.di.providers.OkHttpClientProvider
import dev.bhavindesai.mvvmarch.di.providers.RetrofitProvider
import dev.bhavindesai.mvvmarch.ui.login.LoginRepository
import dev.bhavindesai.mvvmarch.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}

val dbModule = module {
//    single { AppDatabaseProvider.provide(get()) }
}

val daoModule = module {

}

val repositoryModule = module{
    single { LoginRepository(get()) }
}

val networkModule = module {
    single { HttpLoggingInterceptorProvider.provide() }
    single { OkHttpClientProvider.provide(get()) }
    single { GsonConverterFactory.create() }
    single { RetrofitProvider.provide(get(), get()) }
}

val apiServiceModule = module {
    single { ApiService.create(get()) }
}