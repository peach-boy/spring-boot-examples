package com.wxt.common.web;

import com.wxt.common.config.anotation.Authorization;
import com.wxt.common.protocal.ApiResponse;
import com.wxt.common.protocal.SinglePayRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 21:07
 * @Email:1414924381@qq.com
 */
@Api("支付")
@RequestMapping(path = "/pay", method = RequestMethod.POST)
@RestController
public class PaymentController {

    @Authorization
    @ApiOperation(value = "单笔支付")
    @PostMapping(value = "/single_pay")
    public ApiResponse<String> singlePay(@RequestBody @Validated SinglePayRequest request) {
        return ApiResponse.success("orderNo");
    }
}
