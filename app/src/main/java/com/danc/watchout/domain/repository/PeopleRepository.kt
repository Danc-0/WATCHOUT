package com.danc.watchout.domain.repository

import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {

    suspend fun getAllPeople(): Flow<Resource<Peoples>>

}