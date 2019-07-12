package com.example.demo.data.pref;

/**
 * Created by Divyang.
 */

public interface PreferenceHelper {
    void setPreferenceBoolean(int preName, boolean isValue);

    boolean getPreferenceBooleanDefault(int prefName, boolean defaultValue);

    String getPreferenceString(String defaultValue);

    String getPreferenceStringDefault(int prefName, String defaultValue);

    int getPreferenceInt(int prefName, int defaultValue);

    void setPreferenceString(int preName, String defaultValue);

    void setPreferenceInt(int preName, int value);

    void setPreferenceLong(int preName, long value);

    long getPreferenceLong(int preName, long defaultValue);
}
