package com.vamarmu.marvel.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.usecases.GetDetailCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailCharactersUseCase: GetDetailCharactersUseCase,
    private val charactersId : Int
): ViewModel() {

    private val _status = MutableLiveData<UiDetailStatus> ()

    val status : LiveData<UiDetailStatus>
        get() = _status


    init {
        getCharacter()
    }


    private fun getCharacter() = viewModelScope.launch {
        try {
            _status.value  = UiDetailStatus.Loading

            val characters: MarvelCharacter?  = getDetailCharactersUseCase.invoke(charactersId)
            _status.value  = characters?.let {
                UiDetailStatus.DetailContent(it)
            }?:UiDetailStatus.NoContent

        }
        catch (ex : Exception){
            _status.value  = UiDetailStatus.Error(ex.stackTraceToString())

        }


    }


    sealed interface UiDetailStatus {

        object Loading : UiDetailStatus
        object NoContent : UiDetailStatus
        class DetailContent (val characters : MarvelCharacter) : UiDetailStatus
        class Error(val error : String) : UiDetailStatus

    }
}