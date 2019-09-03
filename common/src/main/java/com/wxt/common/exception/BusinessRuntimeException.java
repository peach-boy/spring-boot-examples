package com.wxt.common.exception;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 20:57
 * @Email:1414924381@qq.com
 */
public class BusinessRuntimeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    private int errorCode;
    private String errorMsg;

    public BusinessRuntimeException(ErrorCode errorCode) {
        this(errorCode.getErrorCode(), errorCode.getErrorMsg());
    }

    public BusinessRuntimeException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BusinessRuntimeException occurred, errorCode=" + this.errorCode + ",errorMsg=" + this.errorMsg);
        return sb.toString();
    }
}
