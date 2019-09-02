package com.wxt.protocal.request;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 22:07
 * @Email:1414924381@qq.com
 */
public class SinglePayRequest {
    @ApiModelProperty("外部交易号")
    private String outerTradeNo;

    @ApiModelProperty("交易金额")
    private BigDecimal tradeAmount;

    @ApiModelProperty("付款账户id")
    private Integer payerAccountId;

    @ApiModelProperty("商家收款账户id")
    private Integer sellerAccountId;

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Integer getPayerAccountId() {
        return payerAccountId;
    }

    public void setPayerAccountId(Integer payerAccountId) {
        this.payerAccountId = payerAccountId;
    }

    public Integer getSellerAccountId() {
        return sellerAccountId;
    }

    public void setSellerAccountId(Integer sellerAccountId) {
        this.sellerAccountId = sellerAccountId;
    }

    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
    }
}
