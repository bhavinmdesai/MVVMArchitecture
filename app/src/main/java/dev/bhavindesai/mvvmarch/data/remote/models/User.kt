package dev.bhavindesai.mvvmarch.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.bhavindesai.mvvmarch.data.local.DatabaseConstants

@Entity(tableName = DatabaseConstants.mTableUsers)
data class User (
    @PrimaryKey
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)