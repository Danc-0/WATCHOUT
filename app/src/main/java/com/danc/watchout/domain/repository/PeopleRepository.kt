package com.danc.watchout.domain.repository

import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.models.SpecificFilmResult
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {

    suspend fun getAllPeople(pageNo: Int): Peoples

    suspend fun getSpecificFilm(url: String): Flow<Resource<SpecificFilmResult>>

}