package com.wxt.service;

import com.wxt.domain.entity.ConsumeOrderDO;
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
public class RedPacketService {


    @Transactional
    public Boolean sendRedPacket(SinglePayRequest request) {
         //支付金额大于100,,发放失败
        if(request.getTradeAmount().compareTo(new BigDecimal(100))>0){
            throw new RuntimeException("红包发放失败");
        }
        return Boolean.TRUE;
    }
}
