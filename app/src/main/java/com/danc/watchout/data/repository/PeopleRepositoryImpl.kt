package com.danc.watchout.data.repository

import android.util.Log
import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class PeopleRepositoryImpl(private val starWarsAPI: StarWarsAPI) : PeopleRepository {

    override suspend fun getAllPeople(pageNo: Int): Peoples  {
        try {
            val response = starWarsAPI.getPeople(pageNo).toPeoplesResult()
            Log.d("TAG", "getAllPeople: ${response.results}")
            return response

        } catch (exception: HttpException) {
            throw exception
        }
    }
}