package com.ms.user.exception;

import com.ms.common.exception.BaseSystemException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 * @title: UserException
 * @Description :
 * @Date ： 2020/4/14 12:48
 */
@Slf4j
public class UserException extends BaseSystemException {

    public static final UserException ERROR = new UserException(100000001, "用户异常");

    public UserException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public UserException(int code, String msg) {
        super(code, msg);
    }

    public UserException() {
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public UserException newInstance(String msgFormat, Object... args) {
        return new UserException(this.code, msgFormat, args);
    }

    public UserException print() {
        log.info(" ==> BizException, code:" + this.code + ", msg:" + this.msg);
        return new UserException(this.code, this.msg);
    }
}
