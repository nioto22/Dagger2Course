package com.aprouxdev.dagger2course.ui.auth;

import android.util.Log;

import com.aprouxdev.dagger2course.SessionManager;
import com.aprouxdev.dagger2course.models.User;
import com.aprouxdev.dagger2course.network.auth.AuthApi;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {
    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    // Create a MediatorLiveData
    // With Resource : private MediatorLiveData<User> authUser = new MediatorLiveData<>();
    // become :
    // private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();
    // Now replace by a Session Manager
    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;
        Log.d(TAG, "AuthViewModel: viewModel is working");
    }

    public void authenticateWithId(int userId){
        Log.d(TAG, "authenticateWithId: attempting to log ");

        sessionManager.authenticateWithId(queryUserId(userId));
    }

    private LiveData<AuthResource<User>> queryUserId(int userId){
        return LiveDataReactiveStreams.fromPublisher(    // Conversion Rx to LiveData

            authApi.getUser(userId)

                    // instead of calling onError (if error happens)
                    .onErrorReturn(new Function<Throwable, User>() {
                        @Override
                        public User apply(Throwable throwable) throws Exception {
                            User errorUser = new User();
                            errorUser.setId(-1);
                            return errorUser; // if error return errorUser to the next Map
                        }
                    })

                    .map(new Function<User, AuthResource<User>>() {
                        // this map transform the user or errorUser to a AuthResource status
                        @Override
                        public AuthResource<User> apply(User user) throws Exception {
                            if (user.getId() == -1){
                                return AuthResource.error("Could not authenticate", (User)null);
                                // Activate the onChange observer
                            }
                            return AuthResource.authenticated(user);
                            // Activate the onChange observer
                        }
                    })
                    .subscribeOn(Schedulers.io())
        );
    }

    public LiveData<AuthResource<User>> observeAuthState(){
        return sessionManager.getAuthUser();
    }
}
