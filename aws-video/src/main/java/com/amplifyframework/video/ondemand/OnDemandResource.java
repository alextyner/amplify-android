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

package com.amplifyframework.video.ondemand;

import androidx.annotation.NonNull;

import com.amplifyframework.video.VideoResource;

import java.util.Map;
import java.util.Objects;

/**
 * An on-demand video resource.
 */
public class OnDemandResource extends VideoResource {

    private Map<InputType, String> input;
    private Map<OutputType, String> output;

    /**
     * Constructor for the VideoResource.
     * @param identifier A resource identifier.
     * @param input Video input methods. Typically just an S3 bucket.
     * @param output Video output methods. Typically an S3 bucket resource name.
     */
    public OnDemandResource(@NonNull String identifier, Map<InputType, String> input, Map<OutputType, String> output) {
        super(identifier);
        this.input = Objects.requireNonNull(input);
        this.output = Objects.requireNonNull(output);
    }
}
