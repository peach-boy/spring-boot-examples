package com.wxt.protocal.request;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 22:37
 * @Email:1414924381@qq.com
 */
public class ChargeRequest {
    private Integer accountId;

    private BigDecimal chargeAmount;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }
}
