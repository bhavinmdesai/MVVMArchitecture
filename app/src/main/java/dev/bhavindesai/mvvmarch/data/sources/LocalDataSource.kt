package dev.bhavindesai.mvvmarch.data.sources

import androidx.lifecycle.LiveData

interface LocalDataSource<LocalType> {

    fun getLocalData() : LiveData<LocalType>

    suspend fun storeLocalData(data: LocalType)

}