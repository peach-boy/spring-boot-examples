package com.wxt.web;

import com.wxt.config.mq.RabbitMqConstant;
import com.wxt.service.MessageSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiantao.wu
 * @Email:1414924381@qq.com
 * @create 2019/8/3015:50
 **/
@Api("生产者")
@RestController
@RequestMapping(path = "/producer")
public class ProducerController {

    @Autowired
    private MessageSender messageSender;

    @ApiOperation(value = "发消息", notes = "send")
    @PostMapping(path = "/send_msg")
    public boolean sendMsg(@RequestParam(value = "msg") String msg) {
          messageSender.sendDirect(RabbitMqConstant.DIRECT_EXCHANGE,RabbitMqConstant.ROUTING_KEY_C,msg);
        return Boolean.TRUE;
    }
}
