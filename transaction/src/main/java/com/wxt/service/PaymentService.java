package com.wxt.service;

import com.wxt.domain.entity.AccountDO;
import com.wxt.domain.entity.ConsumeOrderDO;
import com.wxt.domain.mapper.AccountMapper;
import com.wxt.domain.mapper.ConsumeOrderMapper;
import com.wxt.protocal.request.SinglePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 22:10
 * @Email:1414924381@qq.com
 */
@Service
public class PaymentService {

    private static final Integer appId = 100001;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ConsumeOrderMapper consumeOrderMapper;

    @Autowired
    private RedPacketService redPacketService;

    @Transactional
    public Boolean singlePay(SinglePayRequest request) {
        //落订单库
        saveOrder(request);
        //更新账户,因賬戶余额不足，抛出异常
        accountService.updateAccount(request);
        //发放红包
        redPacketService.sendRedPacket(request);
        return Boolean.TRUE;
    }
    public void saveOrder(SinglePayRequest request) {
        ConsumeOrderDO consumeOrderDO = new ConsumeOrderDO();
        consumeOrderDO.setOuterTradeNo(request.getOuterTradeNo());
        consumeOrderDO.setInnerOrderNo(appId + UUID.randomUUID().toString());
        consumeOrderDO.setAmount(request.getTradeAmount());
        consumeOrderDO.setStatus(1);
        consumeOrderMapper.insert(consumeOrderDO);
    }





}
