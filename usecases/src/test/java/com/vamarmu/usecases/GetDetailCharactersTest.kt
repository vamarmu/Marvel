package com.vamarmu.usecases



import com.vamarmu.data.repository.Repository
import com.vamarmu.test.getMockCharacter
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class GetDetailCharactersTest {

    @Mock
    lateinit var repository: Repository

    lateinit var getDetailCharactersUseCase: GetDetailCharactersUseCase

    @Before
    fun setUp(){
        getDetailCharactersUseCase = GetDetailCharactersUseCase(repository = repository)
    }

    @Test
    fun getDetailCharacters(){
        runBlocking {
            whenever( repository.getDetailCharacter(1001)).thenReturn(getMockCharacter())
            val  result = getDetailCharactersUseCase.invoke(1001)
            Assert.assertEquals(getMockCharacter(), result)
        }
    }

}