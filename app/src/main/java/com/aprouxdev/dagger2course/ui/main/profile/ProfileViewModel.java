package com.aprouxdev.dagger2course.ui.main.profile;

import android.util.Log;

import com.aprouxdev.dagger2course.SessionManager;
import com.aprouxdev.dagger2course.models.User;
import com.aprouxdev.dagger2course.ui.auth.AuthResource;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager){
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileViewModel: is correctly injected");
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return sessionManager.getAuthUser();
    }
    
}
