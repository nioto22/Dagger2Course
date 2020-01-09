package com.aprouxdev.dagger2course.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String someString(){
        return "this is a test string";
    }

    @Provides
    static boolean getApp(Application application){
        return application == null; // return true if application is null and false if not
    }


}
