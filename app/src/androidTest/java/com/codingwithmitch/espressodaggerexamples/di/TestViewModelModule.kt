package com.codingwithmitch.espressodaggerexamples.di

import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.espressodaggerexamples.repository.FakeMainRepositoryImpl
import com.codingwithmitch.espressodaggerexamples.viewmodels.FakeMainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestViewModelModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideViewModelFactory(
        mainRepository: FakeMainRepositoryImpl
    ): ViewModelProvider.Factory {
        return FakeMainViewModelFactory(
            mainRepository
        )
    }
}