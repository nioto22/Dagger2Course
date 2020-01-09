package com.aprouxdev.dagger2course.di;

import android.app.Application;

import com.aprouxdev.dagger2course.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                //ViewModelFactoryModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {
    // See AppComponent as a service and BaseApplication as Client


    // override the component object
    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application); //method call by BaseApllication to create instance of AppComponent

        AppComponent build();
    }
}
