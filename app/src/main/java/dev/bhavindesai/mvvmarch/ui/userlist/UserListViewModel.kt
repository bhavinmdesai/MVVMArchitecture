package dev.bhavindesai.mvvmarch.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dev.bhavindesai.mvvmarch.data.remote.models.User
import dev.bhavindesai.mvvmarch.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: UserListRepository
) : BaseViewModel() {

    var userList: LiveData<List<User>> = repository.asLiveData()

    fun getListOfUsers() {
        viewModelScope.launch {
            repository.fetchListOfUsers()
        }
    }
}