package dev.bhavindesai.mvvmarch.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

abstract class BaseViewModel : ViewModel() {

    protected val _showLoader = MutableLiveData<Boolean>()
    val showLoader: LiveData<Boolean> = _showLoader

    val errorMessage = LiveEvent<String>()

    init {
        _showLoader.value = false
    }
}