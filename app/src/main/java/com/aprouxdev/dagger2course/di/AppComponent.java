package com.aprouxdev.dagger2course.di;

import android.app.Application;

import com.aprouxdev.dagger2course.BaseApplication;
import com.aprouxdev.dagger2course.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,
        })
public interface AppComponent extends AndroidInjector<BaseApplication> {
    // See AppComponent as a service and BaseApplication as Client

    SessionManager sessionManager();

    // override the component object
    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application); //method call by BaseApllication to create instance of AppComponent

        AppComponent build();
    }
}
