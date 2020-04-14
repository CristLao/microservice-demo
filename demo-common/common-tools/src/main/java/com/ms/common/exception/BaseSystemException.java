package com.ms.common.exception;

/**
 * @author
 * @title: BaseSystemException
 * @Description :
 * @Date ： 2020/4/14 11:43
 */
public class BaseSystemException extends RuntimeException {

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    protected int type;

    public BaseSystemException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg  = String.format(msgFormat, args);
    }

    public BaseSystemException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public int getType() {
        return type;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BaseSystemException newInstance(String msgFormat, Object... args) {
        return new BaseSystemException(this.code, msgFormat, args);
    }

    public BaseSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseSystemException(Throwable cause) {
        super(cause);
    }

    public BaseSystemException(String message) {
        super(message);
    }
}
