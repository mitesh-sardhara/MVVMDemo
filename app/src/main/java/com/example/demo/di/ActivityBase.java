package com.example.demo.di;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dagger.android.AndroidInjection;

public abstract class ActivityBase<V extends ViewModelBase> extends AppCompatActivity {

    private V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDependencyInjection();
        setUpViewModel();
    }

    /**
     * Method for perform injection for page
     */
    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    /**
     * Get View model of current page
     */
    private void setUpViewModel() {
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
    }

    /**
     * Override for get view model
     *
     * @return
     */
    public abstract V getViewModel();

    /**
     * Override for set current page title
     *
     * @param appTitle
     */
    public abstract void setAppTitle(Object appTitle);
}
