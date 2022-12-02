package com.danc.watchout.domain.usecases

import com.danc.watchout.domain.models.Peoples
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PeoplesUseCase @Inject constructor (private val peopleRepository: PeopleRepository) {

     suspend operator fun invoke(pageNo: Int): Peoples {
        return peopleRepository.getAllPeople(pageNo)
    }

}