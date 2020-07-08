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

package com.amplifyframework.video.util;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.AmplifyConfiguration;
import com.amplifyframework.core.category.CategoryConfiguration;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.video.VideoCategoryConfiguration;
import com.amplifyframework.video.VideoException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Instead of extending the final class {@link AmplifyConfiguration}, here are some helper methods
 * for reading from a non-default config file. They use existing functionality whenever possible.
 */
public final class VideoConfiguration {

    private static final String VIDEO_IDENTIFIER = "videoconfiguration";

    private VideoConfiguration() {}

    /**
     * Amends an existing {@link AmplifyConfiguration} to contain the configuration for Video
     * which is (attempted to be) read from VIDEO_IDENTIFIER.
     * After populating the configuration with Video's configuration, use it to call
     * {@link com.amplifyframework.core.Amplify#configure(AmplifyConfiguration, Context)}.
     * @param context Application context.
     * @param amplifyConfiguration An {@link AmplifyConfiguration}, probably from
     * {@link AmplifyConfiguration#fromConfigFile(Context)}.
     * @return An {@link AmplifyConfiguration} with Video configuration added
     * @throws VideoException If VIDEO_IDENTIFIER is malformed or does not exist.
     */
    @SuppressWarnings("unchecked")
    public static AmplifyConfiguration populate(@NonNull AmplifyConfiguration amplifyConfiguration,
                                                @NonNull Context context) throws VideoException {
        AmplifyConfiguration amplifyConfig = amplifyConfiguration;
        try {
            // A configuration with Video only
            CategoryConfiguration videoConfig = fromConfigFile(context).forCategoryType(CategoryType.VIDEO);

            // The provided configurations -- you've really forced my hand here
            Field configsField = AmplifyConfiguration.class.getDeclaredField("categoryConfigurations");
            configsField.setAccessible(true);
            Map<String, CategoryConfiguration> configs = (Map<String, CategoryConfiguration>)
                    configsField.get(amplifyConfig);

            if (configs == null) { // Video is the only plugin loaded
                amplifyConfig = new AmplifyConfiguration(new HashMap<>());
            }

            // Add Video to the rest of the configurations
            configs.put(CategoryType.VIDEO.toString(), videoConfig);

            configsField.setAccessible(false);

            return amplifyConfig;
        } catch (AmplifyException exception) {
            throw new VideoException("Video configuration file contains malformed JSON.", exception,
                    "Consider re-generating the Amplify Video config files.");
        } catch (Exception exception) { // Exception for older API versions
            // AmplifyConfiguration fields have changed!
            throw new VideoException("The VideoConfiguration class needs to be updated.", exception,
                    "Contact the project maintainers.");
        }
    }

    /** See {@link AmplifyConfiguration}. */
    private static JSONObject readInputJson(Context context, int resourceId) throws AmplifyException {
        InputStream inputStream;

        try {
            inputStream = context.getResources().openRawResource(resourceId);
        } catch (Resources.NotFoundException exception) {
            throw new AmplifyException(
                    "Failed to find " + VIDEO_IDENTIFIER + ".",
                    exception, "Please check that it has been created."
            );
        }

        final Scanner in = new Scanner(inputStream);
        final StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            sb.append(in.nextLine());
        }
        in.close();

        try {
            return new JSONObject(sb.toString());
        } catch (JSONException jsonError) {
            throw new AmplifyException(
                    "Failed to read " + VIDEO_IDENTIFIER + ".",
                    jsonError, "Please check that it is correctly formed."
            );
        }
    }

    /**
     * Creates an {@link AmplifyConfiguration} containing only the
     * {@link VideoCategoryConfiguration}, if it is read successfully from the configuration file.
     * @param context Application context.
     * @return An Amplify configuration with only Video config.
     * @throws AmplifyException If there is a problem with the config file
     */
    private static AmplifyConfiguration fromConfigFile(@NonNull Context context) throws AmplifyException {
        return AmplifyConfiguration.fromConfigFile(context, getConfigResourceId(context));
    }

    /** See {@link com.amplifyframework.core.AmplifyConfiguration}. */
    private static int getConfigResourceId(Context context) throws AmplifyException {
        try {
            return context.getResources()
                    .getIdentifier(VIDEO_IDENTIFIER, "raw", context.getPackageName());
        } catch (Exception exception) {
            throw new AmplifyException(
                    "Failed to read " + VIDEO_IDENTIFIER + ".",
                    exception, "Please check that it is correctly formed."
            );
        }
    }

}
