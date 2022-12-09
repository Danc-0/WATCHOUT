package com.danc.watchout.data.repository

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.models.SpecificFilmResult
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class PeopleRepositoryImpl(private val starWarsAPI: StarWarsAPI) : PeopleRepository {

    override suspend fun getAllPeople(pageNo: Int): Peoples  {
        try {
            return starWarsAPI.getPeople(pageNo).toPeoplesResult()

        } catch (exception: HttpException) {
            throw exception
        }
    }

    override suspend fun getSpecificFilm(url: String): Flow<Resource<SpecificFilmResult>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(starWarsAPI.getSpecificFilms(url).toSpecificFilmResult()))
        } catch (exception: HttpException){
            emit(
                Resource.Error(
                    message = "Oops, Something went wrong try again later."
                )
            )
        }  catch (ioException: IOException){
            emit(
                Resource.Error(
                    message = "Check your internet connection"
                )
            )
        }

    }
}