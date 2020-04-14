package com.ms.common.result;

/**
 * @author
 * @title: ResponseUtil
 * @Description :
 * @Date ： 2020/3/22 21:37
 */
public class ResponseUtil {

    private static final int DEFAULT_OK_CODE    = 0;
    private static final int DEFAULT_ERROR_CODE = -1;

    private static final String DEFAULT_OK_MSG    = "success";
    private static final String DEFAULT_ERROR_MSG = "error";

    public static <T> ApiResponseData<T> ok(T t) {
        return ok(t, DEFAULT_ERROR_MSG);
    }

    public static <T> ApiResponseData<T> ok(T t, String message) {
        return ApiResponseData.<T> builder().result(t)
                                            .code(DEFAULT_OK_CODE)
                                            .message(message)
                                            .success(true)
                                            .timestamp(System.currentTimeMillis())
                                            .build();
    }

    public static <T> ApiResponseData<T> error(T t) {
        return error(t, DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG);
    }

    public static <T> ApiResponseData<T> error() {
        return error(null, DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG);
    }

    public static <T> ApiResponseData<T> error(Integer code, String message) {
        return error(null, code, message);
    }

    public static <T> ApiResponseData<T> error(String message) {
        return error(null, DEFAULT_ERROR_CODE, message);
    }

    public static <T> ApiResponseData<T> error(T t, String message) {
        return error(t, DEFAULT_ERROR_CODE, message);
    }

    public static <T> ApiResponseData<T> error(T t, Integer code, String message) {
        return ApiResponseData.<T> builder().result(t)
                                            .code(code)
                                            .message(message)
                                            .success(false)
                                            .timestamp(System.currentTimeMillis())
                                            .build();
    }
}
