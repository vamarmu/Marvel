package com.vamarmu.usecases


import com.vamarmu.test.*
import com.vamarmu.data.repository.Repository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class GetCharactersTest {

    @Mock
    lateinit var repository: Repository

    lateinit var getCharactersUseCase: GetCharactersUseCase

    @Before
    fun setUp(){
        getCharactersUseCase = GetCharactersUseCase(repository = repository)
    }

    @Test
    fun getAllCharacters(){
        runBlocking {
            whenever( repository.getCharacters(any())).thenReturn(getMockCharacters())
            val  result = getCharactersUseCase.invoke(any())
            Assert.assertEquals(getMockCharacters().size, result?.size)



        }
    }

}