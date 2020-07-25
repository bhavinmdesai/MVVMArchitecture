package dev.bhavindesai.mvvmarch.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.bhavindesai.mvvmarch.data.local.DatabaseConstants
import dev.bhavindesai.mvvmarch.data.remote.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM ${DatabaseConstants.mTableUsers}")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeUsers(users: List<User>)
}