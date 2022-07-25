package com.codingwithmitch.espressodaggerexamples.di

import android.app.Application
import com.codingwithmitch.espressodaggerexamples.api.FakeApiService
import com.codingwithmitch.espressodaggerexamples.fragments.MainNavHostFragment
import com.codingwithmitch.espressodaggerexamples.repository.FakeMainRepositoryImpl
import com.codingwithmitch.espressodaggerexamples.ui.DetailsFragmentTest
import com.codingwithmitch.espressodaggerexamples.ui.ListFragmentIntegrationTest
import com.codingwithmitch.espressodaggerexamples.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Singleton
@Component(modules = [
    TestFragmentModule::class,
    TestViewModelModule::class,
    InternalBindingsModule::class,
    TestAppModule::class
])
interface TestAppComponent: AppComponent {

    val apiService: FakeApiService

    val mainRepository: FakeMainRepositoryImpl

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): TestAppComponent
    }

    fun inject(detailsFragmentTest: DetailsFragmentTest)
    fun inject(listFragmentIntegrationTest: ListFragmentIntegrationTest)
}













