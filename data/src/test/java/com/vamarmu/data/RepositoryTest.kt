package com.vamarmu.data

import com.vamarmu.test.*
import com.vamarmu.data.repository.Repository
import com.vamarmu.data.source.RemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var repository : Repository

    @Before
    fun setUp(){
        repository = Repository(remoteDataSource)
    }

    @Test
    fun getCharacters(){
        runBlocking {

            whenever( remoteDataSource.getCharacters()).thenReturn(getMockCharacters())
            val  result = repository.getCharacters()
            Assert.assertEquals(getMockCharacters().size, result?.size)

        }
    }


    @Test
    fun getCharactersById(){
        runBlocking {
            whenever( remoteDataSource.getDetailCharacter(anyInt())).thenReturn(getMockCharacter())
            val result = repository.getDetailCharacter(1001)
            Assert.assertEquals(getMockCharacter(),result)
        }
    }



}