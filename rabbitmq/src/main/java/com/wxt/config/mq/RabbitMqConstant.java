package com.wxt.config.mq;

/**
 * @author xiantao.wu
 * @Email:1414924381@qq.com
 * @create 2019/8/3016:57
 **/
public interface RabbitMqConstant {
    String DIRECT_EXCHANGE = "direct-exchange";
    String FANOUT_EXCHANGE = "fanout-exchange";
    String TOPIC_EXCHANGE = "topic-exchange";
    String HEADERS_EXCHANGE = "headers-exchange";

    // 消息队列配置
    String QUEUE_A = "queue-a";
    String QUEUE_B = "queue-b";
    String QUEUE_C = "queue-c";
    String QUEUE_D = "queue-d";
    String QUEUE_E = "queue-e";
    String QUEUE_F = "queue-f";
    String QUEUE_G = "queue-g";
    String QUEUE_H = "queue-h";
    String QUEUE_I = "queue-i";


    // 绑定匹配规则[*]表示一个单词,[#]表示任意数量（零个或多个）单词。
    String ROUTING_KEY_A = "route.*";
    String ROUTING_KEY_B = "route.#";
    String ROUTING_KEY_C = "route-c";
    String ROUTING_KEY_D = "route-d";
    String ROUTING_KEY_E = "route-e";

}
