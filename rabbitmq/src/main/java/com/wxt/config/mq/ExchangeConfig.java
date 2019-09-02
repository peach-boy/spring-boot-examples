package com.wxt.config.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/1 21:34
 * @Email:1414924381@qq.com
 */
@Configuration
public class ExchangeConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMqConstant.DIRECT_EXCHANGE, true, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMqConstant.FANOUT_EXCHANGE, true, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMqConstant.TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(RabbitMqConstant.HEADERS_EXCHANGE, true, false);
    }


}
