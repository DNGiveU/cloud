package com.ngiveu.cloud.common.util.exception;

/**
 * @author lengleng
 * @date 2017-12-29 17:05:10
 * 403 授权拒绝
 */
public class CloudDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CloudDeniedException() {
    }

    public CloudDeniedException(String message) {
        super(message);
    }

    public CloudDeniedException(Throwable cause) {
        super(cause);
    }

    public CloudDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CloudDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
