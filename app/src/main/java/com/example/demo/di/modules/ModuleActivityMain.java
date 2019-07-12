package com.example.demo.di.modules;

import android.content.Context;

import com.example.demo.di.DataManager;
import com.example.demo.data.rx.SchedulerProvider;
import com.example.demo.di.annotation.ApplicationContext;
import com.example.demo.utils.NetworkUtils;
import com.example.demo.viewmodel.ViewModelActivityMain;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleActivityMain {

    @Provides
    ViewModelActivityMain providesViewModelActivityMain(@ApplicationContext Context context, DataManager dataManager, NetworkUtils networkUtils, SchedulerProvider schedulerProvider) {
        return new ViewModelActivityMain(context, dataManager, networkUtils, schedulerProvider);
    }


}
