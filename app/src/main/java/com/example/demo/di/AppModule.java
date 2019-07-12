package com.example.demo.di;

import android.app.Application;
import android.content.Context;

import com.example.demo.MyApplication;
import com.example.demo.data.AppDataManager;
import com.example.demo.data.pref.AppPreferenceHelper;
import com.example.demo.data.pref.PreferenceHelper;
import com.example.demo.data.remote.ApiCallFactory;
import com.example.demo.data.remote.ApiHelper;
import com.example.demo.data.rx.AppSchedulerProvider;
import com.example.demo.data.rx.SchedulerProvider;
import com.example.demo.di.annotation.ApplicationContext;
import com.example.demo.di.annotation.PreferenceInfo;
import com.example.demo.utils.Constants;
import com.example.demo.utils.NetworkUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Divyang.
 */

@Module
public class AppModule {

    Application application;

    @Provides
    @ApplicationContext
    Context providesContext(Application application) {
        this.application = application;
        return application;
    }

    @Provides
    @Singleton
    MyApplication providesMyApplication() {
        return (MyApplication) application;
    }

    @Provides
    @PreferenceInfo
    String providesSharedPrefName() {
        return Constants.PREF_APP_NAME;
    }

    @Provides
    @Singleton
    PreferenceHelper providesPreferenceHelper(AppPreferenceHelper appPreferenceHelper) {
        return appPreferenceHelper;
    }

    @Provides
    @Singleton
    ApiHelper providesFactory() {
        return ApiCallFactory.create();
    }

    @Provides
    @Singleton
    DataManager providesDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    NetworkUtils providesNetworkUtils(@ApplicationContext Context context) {
        return new NetworkUtils(context);
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
