package com.aprouxdev.dagger2course.ui.main.posts;

import android.util.Log;

import com.aprouxdev.dagger2course.SessionManager;
import com.aprouxdev.dagger2course.network.main.MainApi;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    // inject
    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi){
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostsViewModel: viewModel is working");
    }
}
