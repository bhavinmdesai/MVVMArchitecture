package dev.bhavindesai.mvvmarch.ui.userlist

import androidx.lifecycle.LiveData
import dev.bhavindesai.mvvmarch.data.local.dao.UserDao
import dev.bhavindesai.mvvmarch.data.remote.ApiService
import dev.bhavindesai.mvvmarch.data.remote.models.BaseResponse
import dev.bhavindesai.mvvmarch.data.remote.models.User
import dev.bhavindesai.mvvmarch.data.sources.MultiDataSource

class UserListRepository(
    apiService: ApiService,
    userDao: UserDao
) {

    private val mdsUserList = object : MultiDataSource<List<User>, Unit, BaseResponse<User>>() {
        override fun mapper(remoteData: BaseResponse<User>): List<User> = remoteData.data

        override fun getLocalData(): LiveData<List<User>> = userDao.getUsers()

        override suspend fun storeLocalData(data: List<User>) = userDao.storeUsers(data)

        override suspend fun getRemoteData(request: Unit): BaseResponse<User>? = try {
                val response = apiService.getUsers()

                response
            } catch (e: Exception) {
                null
            }
        }

        suspend fun fetchListOfUsers() {
            mdsUserList.fetch(Unit)
        }

        fun asLiveData() = mdsUserList.asLiveData()
    }

