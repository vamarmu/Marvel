package com.vamarmu.marvel.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _status = MutableLiveData<UiListStatus> ()

    val status : LiveData<UiListStatus>
        get() = _status


    init {
        _status.value = UiListStatus.Loading
    }


    fun getCharacters() = viewModelScope.launch {
        try {
            _status.value  = UiListStatus.Loading

            val listCharacters: List<MarvelCharacter>?  = getCharactersUseCase.invoke()
            _status.value  = if (listCharacters.isNullOrEmpty())
                UiListStatus.NoContent
            else
                UiListStatus.ListContent(listCharacters)

            Log.d("VMM", "${listCharacters.toString()}")
        }
        catch (ex : Exception){
            _status.value  = UiListStatus.Error(ex.stackTraceToString())
            Log.d("VMM", "${ex.stackTraceToString() }")
        }


    }


    sealed interface UiListStatus {

        object Loading : UiListStatus
        object NoContent : UiListStatus
        class ListContent (val characters : List<MarvelCharacter>) : UiListStatus
        class Error(val error : String) : UiListStatus

    }
}