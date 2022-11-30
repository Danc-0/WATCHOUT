package com.danc.watchout.data.repository

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class PeopleRepositoryImpl(private val starWarsAPI: StarWarsAPI) : PeopleRepository {

    override suspend fun getAllPeople(): Flow<Resource<Peoples>> = flow {
        emit(Resource.Loading())
        try {
            val response = starWarsAPI.getPeople().toPeoplesResult()
            emit(Resource.Success(response))

        } catch (exception: HttpException) {
            emit(Resource.Error("Oops. Something went wrong. Try again later"))
        } catch (exception: IOException) {
            emit(Resource.Error("Check your internet connection and Try Again"))
        }
    }
}