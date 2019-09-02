package com.wxt.service;

import com.wxt.domain.entity.AccountDO;
import com.wxt.domain.entity.ConsumeOrderDO;
import com.wxt.domain.mapper.AccountMapper;
import com.wxt.domain.mapper.ConsumeOrderMapper;
import com.wxt.protocal.request.SinglePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private AccountMapper accountMapper;

    @Autowired
    private ConsumeOrderMapper consumeOrderMapper;


    public Boolean singlePay(SinglePayRequest request) {
        //落订单库
        saveOrder(request);
        //更新账户
        updateAccount(request);
        return Boolean.TRUE;
    }


    public void saveOrder(SinglePayRequest request) {
        ConsumeOrderDO consumeOrderDO = new ConsumeOrderDO();
        consumeOrderDO.setOuterTradeNo(request.getOuterTradeNo());
        consumeOrderDO.setInnerOrderNo(appId + UUID.randomUUID().toString());
        consumeOrderDO.setStatus(1);
        consumeOrderMapper.insert(consumeOrderDO);
    }
    @Transactional
    public void updateAccount(SinglePayRequest request) {
        //商家账户增加
        addSellerAccount(request.getSellerAccountId(), request.getTradeAmount());
        //买家账户扣减
        substratConsumerAccount(request.getPayerAccountId(), request.getTradeAmount());
    }

    public void addSellerAccount(Integer sellerAccountId, BigDecimal tradeAmount) {
        AccountDO accountDO = accountMapper.getById(sellerAccountId);
        BigDecimal newBalance = accountDO.getBalance().add(tradeAmount);
        accountMapper.update(sellerAccountId, newBalance);
    }

    public void substratConsumerAccount(Integer consumerAccountId, BigDecimal tradeAmount) {
        AccountDO accountDO = accountMapper.getById(consumerAccountId);

        if (accountDO.getBalance().compareTo(tradeAmount) < 0) {
            throw new RuntimeException("你的账户余额不足");
        }
        BigDecimal newBalance = accountDO.getBalance().subtract(tradeAmount);
        accountMapper.update(consumerAccountId, newBalance);
    }


}
