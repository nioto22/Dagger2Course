package com.aprouxdev.dagger2course.di.main;

import com.aprouxdev.dagger2course.di.ViewModelKey;
import com.aprouxdev.dagger2course.ui.main.posts.PostsViewModel;
import com.aprouxdev.dagger2course.ui.main.profile.ProfileViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostsViewModel(PostsViewModel viewModel);
}
