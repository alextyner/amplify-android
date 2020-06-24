package com.amplifyframework.video;

import androidx.annotation.NonNull;

import com.amplifyframework.core.category.CategoryConfiguration;
import com.amplifyframework.core.category.CategoryType;

public final class VideoCategoryConfiguration extends CategoryConfiguration {

    /**
     * Gets the category type associated with the current object.
     *
     * @return The category type to which the current object is affiliated
     */
    @NonNull
    @Override
    public CategoryType getCategoryType() { return CategoryType.VIDEO; }
}
