package com.example.demo.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.demo.di.annotation.ApplicationContext;
import com.example.demo.di.annotation.PreferenceInfo;

import javax.inject.Inject;

/**
 * Created by Divyang.
 */

public class AppPreferenceHelper implements PreferenceHelper {
    private SharedPreferences mPreferences;
    private Context mContext;

    @Inject
    AppPreferenceHelper(@ApplicationContext Context context, @PreferenceInfo String prefName) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Override
    public void setPreferenceBoolean(int preName, boolean isValue) {
        mPreferences.edit().putBoolean(mContext.getResources().getString(preName), isValue).apply();
    }

    @Override
    public boolean getPreferenceBooleanDefault(int preName, boolean defaultValue) {
        return mPreferences.getBoolean(mContext.getResources().getString(preName), defaultValue);
    }

    @Override
    public String getPreferenceString(String prefName) {
        return mPreferences.getString(prefName, "");
    }

    @Override
    public String getPreferenceStringDefault(int preName, String defaultValue) {
        return mPreferences.getString(mContext.getResources().getString(preName), defaultValue);
    }

    @Override
    public int getPreferenceInt(int prefName, int defaultValue) {
        return mPreferences.getInt(mContext.getResources().getString(prefName), defaultValue);
    }

    @Override
    public void setPreferenceString(int prefName, String value) {
        mPreferences.edit().putString(mContext.getResources().getString(prefName), value).apply();
    }

    @Override
    public void setPreferenceInt(int preName, int value) {
        mPreferences.edit().putInt(mContext.getResources().getString(preName), value).apply();
    }

    @Override
    public void setPreferenceLong(int preName, long value) {
        mPreferences.edit().putLong(mContext.getResources().getString(preName), value).apply();
    }

    @Override
    public long getPreferenceLong(int preName, long defaultValue) {
        return mPreferences.getLong(mContext.getResources().getString(preName), defaultValue);
    }

}
