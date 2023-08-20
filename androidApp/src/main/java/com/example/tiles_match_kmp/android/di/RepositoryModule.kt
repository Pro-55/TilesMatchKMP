package com.example.tiles_match_kmp.android.di

import com.example.tiles_match_kmp.data.repository.contract.Repository
import com.example.tiles_match_kmp.data.repository.impl.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideRepository(): Repository = RepositoryImpl()

}