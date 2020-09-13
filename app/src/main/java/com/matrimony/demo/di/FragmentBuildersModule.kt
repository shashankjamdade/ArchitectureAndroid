package com.matrimony.demo.di


import com.matrimony.demo.ui.AddFragment
import com.matrimony.demo.ui.EditFragment
import com.matrimony.demo.ui.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


// declare all the fragments here , dependency of fragments are provided by this module

@Module
abstract class FragmentBuildersModule {

//    // Method #1
//    @ContributesAndroidInjector
//    abstract fun contributeListFragment(): ListFragment
//
//    // Method #2
//    @ContributesAndroidInjector
//    abstract fun contributeAddFragment(): AddFragment
//
//    // Method #3
//    @ContributesAndroidInjector
//    abstract fun contributeEditFragment(): EditFragment
}