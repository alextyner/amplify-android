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

import androidx.annotation.NonNull;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

import java.net.URI;

/**
 * Video provides live and/or on-demand media streaming using the HLS protocol.
 * The category is implemented by zero or more {@link VideoPlugin}.
 * The operations made available by the category are defined in the
 * {@link VideoCategoryBehavior}.
 */
public final class VideoCategory extends Category<VideoPlugin<?>> implements VideoCategoryBehavior {

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public CategoryType getCategoryType() {
        return CategoryType.VIDEO;
    }

    @Override
    public URI getEgressFor(String resourceName) {
        return getSelectedPlugin().getEgressFor(resourceName);
    }
}
