package com.vamarmu.marvel.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.vamarmu.usecases.GetDetailCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named


@Module
@InstallIn( ViewModelComponent::class)
object DetailModule {

    @Provides
    fun detailViewModelProvider(
        detailCharactersUseCase : GetDetailCharactersUseCase,
        @Named("charactersId") id : Int
    ) : DetailViewModel = DetailViewModel(
        getDetailCharactersUseCase = detailCharactersUseCase,
        charactersId = id
    )


    @Provides
    @Named("charactersId")
    fun charactersIdProvider (stateHandle: SavedStateHandle) : Int =
        stateHandle.get<Int>(DetailFragment.ARG_CHARACTERS_ID)?:0

}