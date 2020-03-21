package com.ms.common.result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : crist
 * @Description :
 * @Date : 2020/3/21 22:19
 */
@Getter
@Setter
@Builder
public class ApiResponseData <T> implements Serializable {
    /**
     * 返回状态
     */
    private boolean success;
    /**
     * 消息
     */
    private String message;
    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回的数据
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp;
}
