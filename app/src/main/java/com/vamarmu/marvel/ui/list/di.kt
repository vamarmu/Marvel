package com.vamarmu.marvel.ui.list


import com.vamarmu.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn( ViewModelComponent::class)
object ListModule {

    @Provides
    fun listViewModelProvider(
        getCharactersUseCase : GetCharactersUseCase
    ) : ListViewModel = ListViewModel(
        getCharactersUseCase = getCharactersUseCase

    )

}