package com.wxt.common.exception;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 21:00
 * @Email:1414924381@qq.com
 */
public enum ErrorCode {
    /**
     * 1.系统级错误 依赖服务问题
     */
    SYSTEM_ERROR(1008,1,99999,"系统错误"),

    /**
     * 2.应用级错误
     */
    BAD_REQUEST(1008,2,99999,"请求错误"),

    USER_NOT_LOGIN(1008,2,10002,"用户未登录");


    /**
     * 3.业务逻辑错误
     */


    private final int errorCode;
    private final String errorMsg;

    ErrorCode(int firstCode, int secondCode, int thirdCode, String errorMsg) {
        int code = 1000000 * firstCode + 100000 * secondCode + thirdCode;
        this.errorCode = code;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
