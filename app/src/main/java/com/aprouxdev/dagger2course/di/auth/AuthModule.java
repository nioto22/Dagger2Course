package com.aprouxdev.dagger2course.di.auth;

import com.aprouxdev.dagger2course.network.auth.AuthApi;

        import dagger.Module;
        import dagger.Provides;
        import retrofit2.Retrofit;

@Module
public class AuthModule {

    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }
}
