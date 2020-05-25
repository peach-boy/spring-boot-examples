package com.wxt.producer.config;

import com.wxt.rabbitmq.constant.ExchangeConstant;
import com.wxt.rabbitmq.constant.QueueConstant;
import com.wxt.rabbitmq.constant.RouteKeyConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2020/5/23 18:19
 * @Email:1414924381@qq.com
 */
@Configuration
public class MqConfig {
    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.username}")
    private String userName;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.publisher-confirm-type}")
    private CachingConnectionFactory.ConfirmType confirmType;

    @Value("${spring.rabbitmq.publisher-returns}")
    private boolean publisherReturn;


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirmType(confirmType);
        connectionFactory.setPublisherReturns(publisherReturn);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        return template;
    }

    @Bean
    public DirectExchange directExchangeA() {
        return new DirectExchange(ExchangeConstant.DIRECT_EXCHANGE_A, true, false);
    }

    @Bean
    public FanoutExchange fanoutExchangeA() {
        return new FanoutExchange(ExchangeConstant.FANOUT_EXCHANGE_A, true, false);
    }

    @Bean
    public Queue queueA() {
        return new Queue(QueueConstant.QUEUE_A, true, false, false);
    }

    @Bean
    public Binding directBindingQueueD(DirectExchange directExchangeA,Queue queueA) {
        return BindingBuilder.bind(queueA).to(directExchangeA).with(RouteKeyConstant.ROUTEKEY_A);
    }

}
