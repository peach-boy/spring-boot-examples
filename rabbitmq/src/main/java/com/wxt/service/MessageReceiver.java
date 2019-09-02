package com.wxt.service;

import com.rabbitmq.client.Channel;
import com.wxt.config.mq.RabbitMqConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/1 21:50
 * @Email:1414924381@qq.com
 */
@Component
public class MessageReceiver {

    //-------------------------普通队列模式-------------------------------
    @RabbitListener(queues = RabbitMqConstant.QUEUE_A)
    public void receiveQueueA(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (InterruptedException e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }


    //-------------------------topic类型的交换机(主题模式)-------------------------
    @RabbitListener(queues = RabbitMqConstant.QUEUE_B)
    public void receiveQueueB(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqConstant.QUEUE_C)
    public void receiveQueueC(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }


    //-------------------------headers类型的交换机(首部模式)------------------------
    @RabbitListener(queues = RabbitMqConstant.QUEUE_F)
    public void receiveQueueF(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqConstant.QUEUE_I)
    public void receiveQueueI(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }

    }


    //-------------------------direct类型的交换机(直连模式)------------------------
    @RabbitListener(queues = RabbitMqConstant.QUEUE_D)
    public void receiveDirectA(Message message, Channel channel) throws Exception {
        try {

            System.out.println("get it");
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqConstant.QUEUE_E)
    public void receiveDirectB(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }


    //------------------------- fanout类型的交换机(广播模式)-----------------------
    @RabbitListener(queues = RabbitMqConstant.QUEUE_G)
    public void receiveFanoutA(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // true: 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqConstant.QUEUE_H)
    public void receiveFanoutB(Message message, Channel channel) throws Exception {
        try {
            Thread.sleep(3000);
            // 消息确认 false 只确认当前一个消息收到，true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (InterruptedException e) {
            // requeue: true 如果被拒绝的消息应该重新排队，否则为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            e.printStackTrace();
        }
    }
}