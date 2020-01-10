package com.aprouxdev.dagger2course.di;

import com.aprouxdev.dagger2course.viewmodels.ViewModelProviderFactory;


import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    // Responsible for generated depedencies injection from VMFactory class

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

    // @Binds its the same as doing this below when there is nothing before return
//    @Provides
//    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory factory){
//        return factory;
//    }

}
