package dev.bhavindesai.mvvmarch.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.bhavindesai.mvvmarch.data.Resource
import dev.bhavindesai.mvvmarch.data.remote.ApiService
import dev.bhavindesai.mvvmarch.data.remote.models.LoginRequest
import dev.bhavindesai.mvvmarch.data.remote.models.LoginResponse
import dev.bhavindesai.mvvmarch.data.sources.RemoteDataSource

class LoginRepository(apiService: ApiService) {

    private val mldLoginDataState = MutableLiveData<Resource<LoginResponse>>()
    val ldLoginDataState : LiveData<Resource<LoginResponse>> = mldLoginDataState

    private val rdsLogin = object : RemoteDataSource<LoginRequest, LoginResponse> {
        override suspend fun getRemoteData(request: LoginRequest): LoginResponse? {
            mldLoginDataState.value = Resource.Loading()

            return try {
                val loginResponse = apiService.login(request)

                mldLoginDataState.value = Resource.Success(loginResponse)

                loginResponse
            } catch (e: retrofit2.HttpException) {
                mldLoginDataState.value = Resource.Error(e.message ?: "Unknown Error", e)
                null
            }

        }
    }

    suspend fun login(emailAddress: String, password: String) {
        rdsLogin.getRemoteData(LoginRequest(emailAddress, password))
    }
}