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
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

        // override the component object
    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

            AppComponent build();
        }

}
