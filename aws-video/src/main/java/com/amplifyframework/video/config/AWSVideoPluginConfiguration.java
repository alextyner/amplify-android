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

package com.amplifyframework.video.config;

import com.amplifyframework.video.VideoResource;

import java.util.Set;

/**
 * Configuration for the video plugin.
 */
public final class AWSVideoPluginConfiguration {

    private Set<VideoResource> videoResources;

    /**
     * Constructor for {@link AWSVideoPluginConfiguration}.
     * @param videoResources Set of {@link VideoResource} objects.
     */
    public AWSVideoPluginConfiguration(Set<VideoResource> videoResources) {
        this.videoResources = videoResources;
    }

}
