package com.aprouxdev.dagger2course.di;

import com.aprouxdev.dagger2course.di.auth.AuthViewModelsModule;
import com.aprouxdev.dagger2course.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class}
    )
    abstract AuthActivity contributeAuthActivity();
}
