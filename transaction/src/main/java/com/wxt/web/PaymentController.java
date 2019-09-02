package com.wxt.web;

import com.wxt.protocal.request.SinglePayRequest;
import com.wxt.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 22:08
 * @Email:1414924381@qq.com
 */
@Api("支付")
@RequestMapping(path = "/pay", method = RequestMethod.POST)
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "单笔支付", notes = "单笔支付")
    @PostMapping("/singlePay")
    public Boolean singlePay(SinglePayRequest request) {
        return paymentService.singlePay(request);
    }

}
