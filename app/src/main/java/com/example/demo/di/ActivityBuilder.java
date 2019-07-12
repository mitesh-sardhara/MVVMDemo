package com.example.demo.di;

import com.example.demo.activities.ActivityMain;
import com.example.demo.di.modules.ModuleActivityMain;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {ModuleActivityMain.class})
    abstract ActivityMain bindMainActivity();
}
