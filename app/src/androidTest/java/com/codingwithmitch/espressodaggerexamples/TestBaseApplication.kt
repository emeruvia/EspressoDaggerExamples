package com.codingwithmitch.espressodaggerexamples

import com.codingwithmitch.espressodaggerexamples.di.DaggerTestAppComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@UseExperimental(InternalCoroutinesApi::class, ExperimentalCoroutinesApi::class)
class TestBaseApplication : BaseApplication() {

    override fun initAppComponent() {
        appComponent = DaggerTestAppComponent.builder()
            .application(this)
            .build()
    }
}