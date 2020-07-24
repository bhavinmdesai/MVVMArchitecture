package dev.bhavindesai.mvvmarch.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import dev.bhavindesai.mvvmarch.data.Resource
import dev.bhavindesai.mvvmarch.data.remote.models.LoginResponse
import dev.bhavindesai.mvvmarch.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel(private val dataRepository: LoginRepository) : BaseViewModel() {

    val emailAddress = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val mldLoginSuccessful = MutableLiveData<Boolean>()
    val ldLoginSuccessful : LiveData<Boolean> = mldLoginSuccessful

    private val mldToken = MutableLiveData<String>()
    val ldLoginToken : LiveData<String> = mldToken

    private val observer: Observer<Resource<LoginResponse>> = Observer {
        when (it) {
            is Resource.Loading -> _showLoader.value = true

            is Resource.Error -> {
                _showLoader.value = false
                errorMessage.value = it.message
            }

            is Resource.Success -> {
                _showLoader.value = false
                mldLoginSuccessful.value = true
                mldToken.value = it.data.token
            }
        }
    }

    init {
        dataRepository.ldLoginDataState.observeForever(observer)
    }

    fun doLogin() {
        viewModelScope.launch {
            emailAddress.value?.let { emailAddress->
                password.value?.let{password ->
                    dataRepository.login(emailAddress, password)
                }
            }
        }
    }

    override fun onCleared() {
        dataRepository.ldLoginDataState.removeObserver(observer)
    }
}