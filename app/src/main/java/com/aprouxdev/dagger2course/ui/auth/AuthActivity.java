package com.aprouxdev.dagger2course.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aprouxdev.dagger2course.R;
import com.aprouxdev.dagger2course.models.User;
import com.aprouxdev.dagger2course.ui.main.MainActivity;
import com.aprouxdev.dagger2course.viewmodels.ViewModelProviderFactory;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener{
    private static final String TAG = "AuthActivity";

    private AuthViewModel viewModel;

    private EditText userId;

    private ProgressBar progressBar;

    @Inject
    ViewModelProviderFactory providerFactory;  // inject the viewModel depedency which will be used to instantiate our AuthViewModel

    // inject logo
    @Inject
    Drawable logo;
    @Inject
    RequestManager requestManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);

        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);  // Instantiation of our view model

        setLogo();

        subscribeObservers();
    }

    private void subscribeObservers(){
       viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {
           @Override
           public void onChanged(AuthResource<User> userAuthResource) {
               if (userAuthResource != null){
                   switch (userAuthResource.status){
                       case LOADING:{
                            showProgressBar(true);
                           break;
                       }
                       case AUTHENTICATED:{
                            showProgressBar(false);
                           Log.d(TAG, "onChanged: LOGIN SUCCESS: " + userAuthResource.data.getEmail());
                           onLoginSuccess();
                           break;
                       }
                       case ERROR:{
                           showProgressBar(false);
                           Toast.makeText(AuthActivity.this, userAuthResource.message
                                   + "\nYou enter a wrong user number !!", Toast.LENGTH_SHORT).show();
                           break;
                       }
                       case NOT_AUTHENTICATED:{
                           showProgressBar(false);
                           break;
                       }
                   }
               }
           }
       });
    }

    private void showProgressBar(boolean isVisible){
        if (isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private void onLoginSuccess(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setLogo(){
        requestManager
                .load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:{
                attemptLogin();
                break;
            }
        }
    }

    private void attemptLogin() {
        if(TextUtils.isEmpty(userId.getText().toString())){
            return;
        }
        viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }
}
