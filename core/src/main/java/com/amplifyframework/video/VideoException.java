package com.amplifyframework.video;

import androidx.annotation.NonNull;

import com.amplifyframework.AmplifyException;

public class VideoException extends AmplifyException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new exception with a message, root cause, and recovery suggestion.
     * @param message An error message describing why this exception was thrown
     * @param throwable The underlying cause of this exception
     * @param recoverySuggestion Text suggesting a way to recover from the error being described
     */
    public VideoException(
            @NonNull final String message,
            @NonNull final Throwable throwable,
            @NonNull final String recoverySuggestion
    ) {
        super(message, throwable, recoverySuggestion);
    }

    /**
     * Constructs a new exception using a provided message and an associated error.
     * @param message Explains the reason for the exception
     * @param recoverySuggestion Text suggesting a way to recover from the error being described
     */
    public VideoException(
            @NonNull final String message,
            @NonNull final String recoverySuggestion
    ) {
        super(message, recoverySuggestion);
    }
}
