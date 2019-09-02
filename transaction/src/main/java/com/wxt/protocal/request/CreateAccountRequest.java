package com.wxt.protocal.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 21:08
 * @Email:1414924381@qq.com
 */
public class CreateAccountRequest {
    @ApiModelProperty("账户名称")
    private String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
