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
import androidx.annotation.NonNull;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.AmplifyConfiguration;
import com.amplifyframework.video.VideoCategoryConfiguration;

/**
 * Instead of extending the final class {@link AmplifyConfiguration}, here are some helper methods
 * for reading from a non-default config file. They use existing functionality whenever possible.
 */
public final class VideoConfigurationUtil {

    private static final String VIDEO_IDENTIFIER = "videoconfiguration";

    private VideoConfigurationUtil() {}

    /**
     * Creates an {@link AmplifyConfiguration} containing only the
     * {@link VideoCategoryConfiguration}, if it is read successfully from the configuration file.
     * @param context Application context.
     * @return An Amplify configuration with only Video config.
     * @throws AmplifyException If there is a problem with the config file
     */
    public static AmplifyConfiguration fromConfigFile(@NonNull Context context) throws AmplifyException {
        return AmplifyConfiguration.fromConfigFile(context, getConfigResourceId(context));
    }

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
