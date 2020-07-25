package dev.bhavindesai.mvvmarch.data.remote.models

data class BaseResponse<T> (
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<T>
)