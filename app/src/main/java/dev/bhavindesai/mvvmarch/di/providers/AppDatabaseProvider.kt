package dev.bhavindesai.mvvmarch.di.providers

import android.content.Context
import androidx.room.Room
import dev.bhavindesai.mvvmarch.data.local.AppDatabase
import dev.bhavindesai.mvvmarch.data.local.DatabaseConstants

object AppDatabaseProvider {

    fun provide(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DatabaseConstants.dbName
    ).build()
}