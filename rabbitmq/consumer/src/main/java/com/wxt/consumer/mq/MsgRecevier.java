package com.wxt.consumer.mq;

import com.rabbitmq.client.Channel;
import com.wxt.rabbitmq.constant.ExchangeConstant;
import com.wxt.rabbitmq.constant.QueueConstant;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2020/5/24 09:44
 * @Email:1414924381@qq.com
 */
@Component
public class MsgRecevier {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = QueueConstant.QUEUE_A, durable = "true"),
            exchange = @Exchange(value = ExchangeConstant.DIRECT_EXCHANGE_A)))
    public void receiveDirect(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            String msg = new String(message.getBody());
            System.out.println("收到消息：" + msg);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicReject(tag, true);
        }
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = QueueConstant.QUEUE_E, durable = "true"),
            exchange = @Exchange(value = ExchangeConstant.FANOUT_EXCHANGE_A)))
    public void receiveFanout(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            String msg = new String(message.getBody());
            System.out.println("收到消息：" + msg);

            //执行业务逻辑

            //返回ack
            channel.basicAck(tag, false);
        } catch (Exception e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicReject(tag, true);
        }
    }
}
