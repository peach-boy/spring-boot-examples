package com.wxt.web;

import com.wxt.protocal.CreatePersonRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/2 21:35
 * @Email:1414924381@qq.com
 */
@Api("会员")
@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @ApiOperation(value = "创建用户", notes = "person")
    @PostMapping(value = "/create")
    public String HelloWorld(CreatePersonRequest request) {
        return "hello swagger";
    }
}
