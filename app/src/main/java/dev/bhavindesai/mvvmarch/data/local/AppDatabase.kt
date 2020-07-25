package dev.bhavindesai.mvvmarch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.bhavindesai.mvvmarch.data.local.dao.UserDao
import dev.bhavindesai.mvvmarch.data.remote.models.User

@Database(
    entities = [User::class], version = DatabaseConstants.dbVersion, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}