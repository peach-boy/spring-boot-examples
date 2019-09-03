package com.wxt.common.protocal;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wxt.common.exception.ErrorCode;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 21:36
 * @Email:1414924381@qq.com
 */
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private T data;

    public ApiResponse() {
    }

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> apiResponse = new ApiResponse();
        apiResponse.setCode(0);
        apiResponse.setMsg("OK");
        apiResponse.setData(data);
        return apiResponse;
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        ApiResponse<T> apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getErrorCode());
        apiResponse.setMsg(errorCode.getErrorMsg());
        return apiResponse;
    }
    public static <T> ApiResponse<T> fail(ErrorCode errorCode, T data) {
        ApiResponse<T> apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getErrorCode());
        apiResponse.setMsg(errorCode.getErrorMsg());
        apiResponse.setData(data);
        return apiResponse;
    }
    public static <T> ApiResponse<T> fail(int code, String msg) {
        ApiResponse<T> apiResponse = new ApiResponse();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return JSONObject.toJSONString(this, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
    }
}
