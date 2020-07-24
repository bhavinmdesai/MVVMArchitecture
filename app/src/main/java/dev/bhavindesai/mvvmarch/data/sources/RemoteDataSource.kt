package dev.bhavindesai.mvvmarch.data.sources

interface RemoteDataSource<RequestType, ResponseType> {
    suspend fun getRemoteData(request: RequestType) : ResponseType?
}