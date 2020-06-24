package com.amplifyframework.video;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;

import org.json.JSONObject;

public class AWSVideoPlugin extends VideoPlugin<Void> {
    private static final String AWS_VIDEO_PLUGIN_KEY = "awsVideoPlugin";

    @NonNull
    @Override
    public String getPluginKey() { return AWS_VIDEO_PLUGIN_KEY; }

    @Override
    public void configure(JSONObject pluginConfiguration, @NonNull Context context) throws AmplifyException {

    }

    @Override
    public void initialize(@NonNull Context context) throws AmplifyException {

    }

    @Nullable
    @Override
    public Void getEscapeHatch() {
        return null;
    }

    @NonNull
    @Override
    public CategoryType getCategoryType() {
        return null;
    }
}
