package com.wxt.common.config.aop;

import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.common.exception.ErrorCode;
import com.wxt.common.protocal.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 21:31
 * @Email:1414924381@qq.com
 */
@ControllerAdvice("com.wxt.common.web")
public class ExceptionHandlerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(BusinessRuntimeException.class)
    @ResponseBody
    public ApiResponse handleValidateException(BusinessRuntimeException e) {
        LOGGER.error("业务异常：errorCode:{},errorMsg:{}", e.getErrorCode(), e.getErrorMsg());
        return ApiResponse.fail(e.getErrorCode(), e.getErrorMsg());
    }
}
