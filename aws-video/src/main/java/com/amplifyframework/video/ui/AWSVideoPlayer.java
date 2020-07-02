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

package com.amplifyframework.video.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.MediaController;
import androidx.annotation.RequiresApi;

/**
 * A video player for Amplify Video.
 */
public class AWSVideoPlayer extends VideoPlayer {

    private boolean showControls;
    private MediaController controller;

    /**
     * Constructor.
     *
     * @param context App context.
     */
    public AWSVideoPlayer(Context context) {
        super(context);
    }

    /**
     * Constructor.
     *
     * @param context App context.
     * @param attrs   Attributes.
     */
    public AWSVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor.
     *
     * @param context      App context.
     * @param attrs        Attributes.
     * @param defStyleAttr Style attributes.
     */
    public AWSVideoPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Constructor.
     *
     * @param context      App context.
     * @param attrs        Attributes.
     * @param defStyleAttr Style attributes.
     * @param defStyleRes  Style resources.
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AWSVideoPlayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Adds or removes player controls.
     * @param showControls Whether this player should show controls.
     */
    public void showControls(boolean showControls) {
        this.showControls = showControls;
        if (showControls && controller == null) {
            controller = new MediaController(getContext());
        } else if (!showControls && controller != null) {
            controller = null;
        }
    }

}
