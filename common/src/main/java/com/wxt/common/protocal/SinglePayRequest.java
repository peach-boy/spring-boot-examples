package com.wxt.common.protocal;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 22:22
 * @Email:1414924381@qq.com
 */
public class SinglePayRequest {
    @ApiModelProperty("交易金额")
    @NotNull
    private BigDecimal tradeAmount;

    @ApiModelProperty("商品名称")
    @NotEmpty
    private String productName;
}
