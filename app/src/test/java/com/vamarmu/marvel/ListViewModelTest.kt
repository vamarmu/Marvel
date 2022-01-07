package com.vamarmu.marvel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vamarmu.marvel.ui.list.ListViewModel
import com.vamarmu.usecases.GetCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InOrder
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*



@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ListViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    @Mock
    lateinit var observer: Observer<ListViewModel.UiListStatus>

    private lateinit var vm : ListViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        vm = ListViewModel(getCharactersUseCase)
    }



    @Test
    fun showLoading (){
        testDispatcher.runBlockingTest   {
            vm.status.observeForever(observer)
            vm.getCharacters()
            Mockito.verify(observer).onChanged(ListViewModel.UiListStatus.Loading)
        }
    }


    @Test
    fun showNoContent (){
        testDispatcher.runBlockingTest   {
            whenever(getCharactersUseCase.invoke()).thenReturn(null)
            vm.status.observeForever(observer)
            vm.getCharacters()
            val inOrder: InOrder = inOrder(observer)
            inOrder.verify(observer).onChanged(ListViewModel.UiListStatus.Loading)
            inOrder.verify(observer).onChanged(ListViewModel.UiListStatus.NoContent)
        }
    }
}