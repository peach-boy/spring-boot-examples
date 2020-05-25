package com.wxt.producer.web;

import com.wxt.producer.component.MsgDirectSender;
import com.wxt.producer.component.MsgFanoutSender;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2020/5/23 18:12
 * @Email:1414924381@qq.com
 */
@RestController
public class ProducerController {

    @Resource
    private MsgDirectSender msgDirectSender;

    @Resource
    private MsgFanoutSender msgFanoutSender;

    @ApiOperation(value = "发送direct消息", notes = "发送消息")
    @PostMapping("/sendDirect")
    public Boolean sendDirect(@RequestParam String msg,@RequestParam String orderNo) {
        return msgDirectSender.send(msg,orderNo);
    }

    @ApiOperation(value = "发送fanout消息", notes = "发送消息")
    @PostMapping("/sendFanout")
    public Boolean sendFanout(@RequestParam String msg) {
        return msgFanoutSender.send(msg);
    }

}
