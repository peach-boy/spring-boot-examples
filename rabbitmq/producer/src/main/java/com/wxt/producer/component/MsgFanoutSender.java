package com.wxt.producer.component;

import com.wxt.rabbitmq.constant.ExchangeConstant;
import com.wxt.rabbitmq.constant.RouteKeyConstant;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2020/5/23 18:32
 * @Email:xiantao.wu@guanaitong.com
 */
@Component
public class MsgFanoutSender  {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean send(String msg) {
        rabbitTemplate.setExchange(ExchangeConstant.FANOUT_EXCHANGE_A);
        rabbitTemplate.convertAndSend(msg);
        return false;
    }
}
