package com.aprouxdev.dagger2course.di;

import com.aprouxdev.dagger2course.di.auth.AuthModule;
import com.aprouxdev.dagger2course.di.auth.AuthScope;
import com.aprouxdev.dagger2course.di.auth.AuthViewModelsModule;
import com.aprouxdev.dagger2course.di.main.MainFragmentBuildersModule;
import com.aprouxdev.dagger2course.di.main.MainModule;
import com.aprouxdev.dagger2course.di.main.MainScope;
import com.aprouxdev.dagger2course.di.main.MainViewModelsModule;
import com.aprouxdev.dagger2course.ui.auth.AuthActivity;
import com.aprouxdev.dagger2course.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
