package com.aprouxdev.dagger2course.di.auth;

import com.aprouxdev.dagger2course.di.ViewModelKey;
import com.aprouxdev.dagger2course.ui.auth.AuthViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {
    // responsible to injected ViewModel in AuthActivity

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);


}
