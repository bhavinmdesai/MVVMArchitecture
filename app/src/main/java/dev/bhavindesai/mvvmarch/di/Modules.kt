package dev.bhavindesai.mvvmarch.di

import dev.bhavindesai.mvvmarch.data.local.AppDatabase
import dev.bhavindesai.mvvmarch.data.remote.ApiService
import dev.bhavindesai.mvvmarch.di.providers.*
import dev.bhavindesai.mvvmarch.ui.login.LoginRepository
import dev.bhavindesai.mvvmarch.ui.login.LoginViewModel
import dev.bhavindesai.mvvmarch.ui.userlist.UserListRepository
import dev.bhavindesai.mvvmarch.ui.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { UserListViewModel(get()) }
}

val dbModule = module {
    single { AppDatabaseProvider.provide(get()) }
}

val daoModule = module {
    single { get<AppDatabase>().userDao() }
}

val repositoryModule = module{
    single { LoginRepository(get()) }
    single { UserListRepository(get(), get()) }
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