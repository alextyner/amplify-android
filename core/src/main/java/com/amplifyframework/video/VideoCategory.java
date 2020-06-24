package com.amplifyframework.video;

import androidx.annotation.NonNull;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

public class VideoCategory extends Category<VideoPlugin<?>> implements VideoCategoryBehavior {

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public CategoryType getCategoryType() { return CategoryType.VIDEO; }


}
