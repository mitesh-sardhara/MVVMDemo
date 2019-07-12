package com.example.demo.data;

import android.content.Context;

import com.example.demo.data.pref.PreferenceHelper;
import com.example.demo.data.remote.ApiHelper;
import com.example.demo.di.DataManager;
import com.example.demo.di.annotation.ApplicationContext;
import com.example.demo.pojo.PojoUsers;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private Context mContext;
    private ApiHelper apiHelper;
    private PreferenceHelper preferenceHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context mContext, PreferenceHelper preferenceHelper, ApiHelper apiHelper) {

        this.mContext = mContext;
        this.apiHelper = apiHelper;
        this.preferenceHelper = preferenceHelper;
    }

    @Override
    public void setPreferenceBoolean(int preName, boolean isValue) {
        preferenceHelper.setPreferenceBoolean(preName, isValue);
    }

    @Override
    public boolean getPreferenceBooleanDefault(int prefName, boolean defaultValue) {
        return preferenceHelper.getPreferenceBooleanDefault(prefName, defaultValue);
    }

    @Override
    public String getPreferenceString(String defaultValue) {
        return preferenceHelper.getPreferenceString(defaultValue);
    }

    @Override
    public String getPreferenceStringDefault(int prefName, String defaultValue) {
        return preferenceHelper.getPreferenceStringDefault(prefName, defaultValue);
    }

    @Override
    public int getPreferenceInt(int prefName, int defaultValue) {
        return preferenceHelper.getPreferenceInt(prefName, defaultValue);
    }

    @Override
    public void setPreferenceString(int preName, String defaultValue) {
        preferenceHelper.setPreferenceString(preName, defaultValue);
    }

    @Override
    public void setPreferenceInt(int preName, int value) {
        preferenceHelper.setPreferenceInt(preName, value);
    }

    @Override
    public void setPreferenceLong(int preName, long value) {
        preferenceHelper.setPreferenceLong(preName,value);
    }

    @Override
    public long getPreferenceLong(int preName, long defaultValue) {
        return preferenceHelper.getPreferenceLong(preName, defaultValue);
    }

    @Override
    public Observable<PojoUsers> getUserList(Map<String, Object> params) {
        return apiHelper.getUserList(params);
    }
}
