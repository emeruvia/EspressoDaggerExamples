package com.codingwithmitch.espressodaggerexamples.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.espressodaggerexamples.repository.FakeMainRepositoryImpl
import com.codingwithmitch.espressodaggerexamples.ui.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeMainViewModelFactory @Inject constructor(
    private val mainRepositoryImpl: FakeMainRepositoryImpl
) : ViewModelProvider.Factory {

    @UseExperimental(InternalCoroutinesApi::class, ExperimentalCoroutinesApi::class)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mainRepositoryImpl) as T
        }
        throw IllegalArgumentException("Unnkown ViewModel class")
    }
}