package com.vamarmu.usecases

import com.vamarmu.data.repository.Repository

class GetCharactersUseCase (
    private val repository: Repository
) {

    suspend fun invoke(offset : Int) = repository.getCharacters(offset)
}