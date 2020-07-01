/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amplifyframework.video;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amplifyframework.video.config.AWSVideoPluginConfiguration;
import com.amplifyframework.video.config.AWSVideoPluginConfigurationReader;

import org.json.JSONObject;

/**
 * An AWS implementation of the {@link VideoPlugin}.
 */
public class AWSVideoPlugin extends VideoPlugin<Void> {
    private static final String AWS_VIDEO_PLUGIN_KEY = "awsVideoPlugin";

    private AWSVideoPluginConfiguration configuration;

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public String getPluginKey() {
        return AWS_VIDEO_PLUGIN_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(JSONObject pluginConfiguration, @NonNull Context context) throws VideoException {
        // TODO: remove these
        Log.d("HELLO", pluginConfiguration.toString());
        this.configuration = AWSVideoPluginConfigurationReader.readFrom(pluginConfiguration);
        Log.d("HELLO", String.valueOf(configuration));
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public Void getEscapeHatch() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Uri getEgressFor(String resourceName) {
        return null;
    }

}
