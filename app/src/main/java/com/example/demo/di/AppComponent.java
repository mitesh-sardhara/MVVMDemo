package com.example.demo.di;

import android.app.Application;

import com.example.demo.MyApplication;
import com.example.demo.data.rx.SchedulerProvider;
import com.example.demo.utils.NetworkUtils;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Divyang.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builders {

        @BindsInstance
        Builders application(Application application);

        AppComponent build();
    }

    void inject(MyApplication myApplication);

    DataManager getDataManager();

    SchedulerProvider getSchedulerProvider();

    NetworkUtils getNetworkUtils();
}
