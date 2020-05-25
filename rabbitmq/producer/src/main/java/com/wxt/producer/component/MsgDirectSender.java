package com.wxt.producer.component;

import com.wxt.rabbitmq.constant.ExchangeConstant;
import com.wxt.rabbitmq.constant.QueueConstant;
import com.wxt.rabbitmq.constant.RouteKeyConstant;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2020/5/23 18:32
 * @Email:1414924381@qq.com
 */
@Component
public class MsgDirectSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public boolean send(String msg, String orderNo) {
        rabbitTemplate.setExchange(ExchangeConstant.DIRECT_EXCHANGE_A);
        rabbitTemplate.setRoutingKey(RouteKeyConstant.ROUTEKEY_A);
        rabbitTemplate.setConfirmCallback((correlationData, ack, s) -> {
            String sourceOrderNo = correlationData.getId();
            if (ack) {
                System.out.println("订单:"+sourceOrderNo+"推送成功");
            } else {
                System.out.println("订单:"+sourceOrderNo+"推送失败");
            }
        });
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("================");
            System.out.println("message = " + message);
            System.out.println("replyCode = " + replyCode);
            System.out.println("replyText = " + replyText);
            System.out.println("exchange = " + exchange);
            System.out.println("routingKey = " + routingKey);
            System.out.println("================");
        });
        CorrelationData correlationData=new CorrelationData(orderNo);
        rabbitTemplate.correlationConvertAndSend(msg, correlationData);
        return true;
    }
}
