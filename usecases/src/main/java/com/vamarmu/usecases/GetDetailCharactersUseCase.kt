package com.vamarmu.usecases

import com.vamarmu.data.repository.Repository

class GetDetailCharactersUseCase  (
    private val repository: Repository
    )
{
    suspend fun invoke(id : Int) = repository.getDetailCharacter(id)
}