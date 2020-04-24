package com.ms.user.support.advice;

import com.ms.common.exception.BaseSystemException;
import com.ms.common.result.ApiResponseData;
import com.ms.common.result.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import static com.ms.common.exception.ErrorCodeEnum.*;


/**
 * @author
 * @title: ErrorHandler
 * @Description :
 * @Date ： 2020/4/14 11:27
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponseData handleBindException(BindException ex) {
        log.error("参数绑定异常: {}", ex.getMessage(), ex);
        return ResponseUtil.error(ex.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(BaseSystemException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponseData handleBindException(BaseSystemException ex) {
        log.error("业务异常: {}", ex.getMessage(), ex);
        return ResponseUtil.error(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseData handleAllException(Throwable ex, HttpServletRequest req) {
        log.error("系统异常: {}", ex.getMessage(), ex);
        return ResponseUtil.error(ERR_SYS_PARAM.getErrorCode(), ERR_SYS_PARAM.getErrorDesc());
    }

    /**
     * 参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponseData handleValidateException(MethodArgumentNotValidException ex) {
        log.error("参数校验失败: {}", ex.getMessage(), ex);
        return ResponseUtil.error(ERR_CHECK_PARAM.getErrorCode(),
                                  ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponseData handleMissingParamsException(MissingServletRequestParameterException ex) {
        log.error("参数缺失: {}", ex.getMessage(), ex);
        return ResponseUtil.error(ERR_MISS_PARAM.getErrorCode(), "缺失参数:" + ex.getParameterName());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponseData handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("参数校验失败: {}", ex.getMessage(), ex);
        return ResponseUtil.error(ERR_CHECK_PARAM.getErrorCode(),
                                  ex.getConstraintViolations().iterator().next().getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseData exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseUtil.error();
    }
}
